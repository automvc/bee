package org.teasoft.bee.osql;

/**
 * SQL语言的排序类型(asc,desc).SQL's Order type(asc,desc).
 * @author Kingstar
 * @since  1.0
 */
public enum OrderType {
    ASC("asc"),DESC("desc");
    String name;
    
    OrderType(String name){
    	this.name = name;  
    }
    
    /**
     * 返回排序类型.
     * @return type of order.
     */
    public String getName(){
    	return name;
    }

}
