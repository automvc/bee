package org.bee.osql.chain;

import org.bee.osql.chain.Select;

/**
 * @author Kingstar
 * @since  1.3
 */
public interface UnionSelect extends ToSql{
	
	public UnionSelect union(Select subSelect1,Select subSelect2);
	
	public UnionSelect union(String subSelect1,String subSelect2);
	
	public UnionSelect unionAll(Select subSelect1,Select subSelect2);
	
	public UnionSelect unionAll(String subSelect1,String subSelect2);

//	public String toSQL();
//	
//	public String toSQL(boolean noSemicolon) ;
}
