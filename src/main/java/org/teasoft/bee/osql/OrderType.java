package org.teasoft.bee.osql;

/**
 * SQL语言的排序类型(asc,desc).SQL's Order type(asc,desc).
 * @author Kingstar
 * @since  1.0
 */
public enum OrderType {
	
	/**
	 * 顺序,对应SQL的asc.Corresponding to ASC of SQL
	 */
    ASC("asc"),
    
	/**
	 * 倒序,对应SQL的desc.Corresponding to desc of SQL
	 */
    DESC("desc");
    
    String name;
    
    OrderType(String name){
    	this.name = name;  
    }
    
    /**
     * 返回排序类型.return type of order.
     * @return type of order.
     */
    public String getName(){
    	return name;
    }

}
