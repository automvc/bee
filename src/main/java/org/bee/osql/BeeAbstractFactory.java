package org.bee.osql;

import javax.sql.DataSource;

import org.bee.osql.transaction.Transaction;

/**
 * @author KingStar
 * @since  1.0
 */
public abstract class BeeAbstractFactory {

	private DataSource dataSource;
	private Transaction transaction;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
