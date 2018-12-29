package org.bee.osql.chain;

/**
 * @author Kingstar
 * @since  1.3
 */
public interface ToSql {
	public String toSQL();
	public String toSQL(boolean noSemicolon);
}
