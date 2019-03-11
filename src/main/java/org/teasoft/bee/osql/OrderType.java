package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.0
 */
public enum OrderType {
    ASC("asc"),DESC("desc");
    String name;
    
    OrderType(String name){
    	this.name = name;  
    }
    
    public String getName(){
    	return name;
    }

}
