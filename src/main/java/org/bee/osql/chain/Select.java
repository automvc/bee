package org.bee.osql.chain;

import org.bee.osql.Op;
import org.bee.osql.OrderType;

/**
 * @author Kingstar
 * @since  1.3
 */
public interface Select extends ToSql{
	
	public Select lParentheses();
	public Select rParentheses();
	
	
	//<==============condition
	public Select op(String field, Op opType, String value);

	public Select op(String field, Op opType, Number value);

	/**
	 * 默认自动加 and default will automatically add and
	 * 
	 * @return
	 */
	public Select and();

	public Select or();
	
	
	public Select where();

	public Select where(String expression) ;
	//=============>
	
	public Select select() ;

	public Select select(String column);

	public Select distinct(String field) ;

	public Select from(String table);

	public Select join(String anotherTable) ;

	public Select innerjoin(String anotherTable);

	public Select leftjoin(String anotherTable);

	public Select rightjoin(String anotherTable);

	public Select on();

	public Select on(String expression);

	public Select between(String field, Number low, Number high);
	public Select notBetween(String field, Number low, Number high);

	public Select isNull(String field);
	public Select isNotNull(String field);

	public Select in(String field, Number... valueList);
	public Select notIn(String field, Number... valueList);
	
	public Select in(String field, String valueList);
	public Select notIn(String field, String valueList);

	public Select groupBy(String field);

	public Select having(String expression);

	public Select orderBy(String field);

	public Select orderBy(String field, OrderType orderType);

	public Select start(int start) ;

	public Select size(int size) ;

	public Select exists(Select subSelect) ;
	public Select exists(String subSelect);
	public Select notExists(Select subSelect);
	public Select notExists(String subSelect);
	
	public Select in(Select subSelect);
	public Select in(String subSelect) ;
	public Select notIn(Select subSelect);
	public Select notIn(String subSelect);
}
