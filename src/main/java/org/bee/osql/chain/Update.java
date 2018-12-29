package org.bee.osql.chain;

import org.bee.osql.Op;

/**
 * @author Kingstar
 * @since  1.3
 */
public interface Update extends ToSql{

	public Update update(String table) ;
	public Update set(String field, String value);
	public Update set(String field, Number value);
	
	//<==============condition
	public Update op(String field, Op opType, String value);

	public Update op(String field, Op opType, Number value);

	/**
	 * 默认自动加 and default will automatically add and
	 * 
	 * @return
	 */
	public Update and();

	public Update or();
	
	
	public Update where();

	public Update where(String expression) ;
	//=============>
}
