package org.bee.osql.transaction;

import java.sql.SQLException;

/**
 * @author KingStar
 * @since  1.0
 */
public interface Transaction {
	
	public void begin() throws SQLException; 
	public void commit() throws SQLException; 
	public void rollback() throws SQLException;
	
	public void setReadOnly(boolean readOnly) throws SQLException;
	public void setTransactionIsolation(TransactionIsolationLevel level) throws SQLException;

	public boolean isReadOnly() throws SQLException;
	public int getTransactionIsolation() throws SQLException;
	
	public void setTimeout(int second);
}
