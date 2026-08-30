/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teasoft.bee.osql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * For Select ResuletSet. And close ResultSet/PreparedStatement/Connection with
 * close() method.
 */
public final class SelectRsWrap implements AutoCloseable {

	private final Connection connection;
	private final PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private PostgreSQLBehavior postgreSQLBehavior = null; // for PostgreSQL, GaussDB, OpenGauss ...

	public SelectRsWrap(Connection connection, PreparedStatement preparedStatement) {
		this.connection = connection;
		this.preparedStatement = preparedStatement;
	}

	public SelectRsWrap(Connection connection,
			PreparedStatement preparedStatement,
			boolean isPostgreSQLJDBCStream,
			Boolean oldAutoCommitForPostgreSQLJDBCStreamConn) {
		this.connection = connection;
		this.preparedStatement = preparedStatement;
		if (isPostgreSQLJDBCStream) {
			postgreSQLBehavior = new PostgreSQLBehavior(oldAutoCommitForPostgreSQLJDBCStreamConn);
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	/**
	 * PostgreSql use stream query need set this method. If do set, mean is success.
	 * 
	 * @param haveExceptionProcessPostgreSqlRs
	 */
	public void setHaveExceptionProcessPostgreSqlRs(boolean haveExceptionProcessPostgreSqlRs) {
		if (postgreSQLBehavior != null) {
			postgreSQLBehavior.setHaveExceptionProcessPostgreSqlRs(haveExceptionProcessPostgreSqlRs);
		}
	}

	@Override
	public void close() {
		SQLException error = null;

		try {
			if (resultSet != null) {
//				System.out.println("-------------close rs");
				resultSet.close();
			}
		} catch (SQLException e) {
			error = e;
		}

		try {
			if (preparedStatement != null) {
//				System.out.println("-------------close pst");
				preparedStatement.close();
			}
		} catch (SQLException e) {
			if (error == null) error = e;
		}

		// processCommit for postgreSQLBehavior
		try {
			if (postgreSQLBehavior != null) postgreSQLBehavior.processCommit(connection);
		} catch (SQLException e) {
			if (error == null) error = e;
		}

		try {
			if (connection != null) {
//				System.out.println("-------------close conn");
				connection.close();
//				System.out.println("------------connection.isClosed(): " + connection.isClosed()); // true
//				connection.close();
			}
		} catch (SQLException e) {
			if (error == null) error = e;
		}

		if (error != null) {
			throw new BeeSQLException(error.getMessage(), error.getSQLState(), error.getErrorCode(), error);
		}
	}

	private class PostgreSQLBehavior {
//		private final boolean isPostgreSQLJDBCStream;
		private final Boolean oldAutoCommitForPostgreSQLJDBCStreamConn;

		private Boolean haveExceptionProcessPostgreSqlRs = null;

//		public PostgreSQLBehavior(boolean isPostgreSQLJDBCStream, Boolean oldAutoCommitForPostgreSQLJDBCStreamConn) {
		PostgreSQLBehavior(Boolean oldAutoCommitForPostgreSQLJDBCStreamConn) {
//			this.isPostgreSQLJDBCStream = isPostgreSQLJDBCStream;
			this.oldAutoCommitForPostgreSQLJDBCStreamConn = oldAutoCommitForPostgreSQLJDBCStreamConn;
		}

		Boolean getOldAutoCommitForPostgreSQLJDBCStreamConn() {
			return oldAutoCommitForPostgreSQLJDBCStreamConn;
		}

		Boolean getHaveExceptionProcessPostgreSqlRs() {
			return haveExceptionProcessPostgreSqlRs;
		}

		void setHaveExceptionProcessPostgreSqlRs(Boolean haveExceptionProcessPostgreSqlRs) {
			this.haveExceptionProcessPostgreSqlRs = haveExceptionProcessPostgreSqlRs;
		}

		void processCommit(Connection connection) throws SQLException {
			if (connection != null) {
//				if (getHaveExceptionProcessPostgreSqlRs() == null) {
//					System.out.println("-------------still do not set setHaveExceptionProcessPostgreSqlRs(..)");
//				}
				if (Boolean.TRUE.equals(getHaveExceptionProcessPostgreSqlRs())) {
					connection.rollback();
				} else {
					connection.commit();
				}

//				if (Boolean.TRUE.equals(getOldAutoCommitForPostgreSQLJDBCStreamConn())) {
//					connection.setAutoCommit(true);
//				}
				if (getOldAutoCommitForPostgreSQLJDBCStreamConn() != null) {
					connection.setAutoCommit(getOldAutoCommitForPostgreSQLJDBCStreamConn());
				}
			}
		}
	}
}