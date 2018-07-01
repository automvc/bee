package org.bee.osql.transaction;

/**
 * @author KingStar
 * @since  1.0
 */
public enum TransactionIsolationLevel
{
    TRANSACTION_NONE(0), 
    TRANSACTION_READ_UNCOMMITTED(1), 
    TRANSACTION_READ_COMMITTED(2), 

    TRANSACTION_REPEATABLE_READ(4), 
    TRANSACTION_SERIALIZABLE(8);

	private final int level;

	private TransactionIsolationLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}

