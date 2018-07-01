package org.bee.osql;

/**
 * @author KingStar
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
