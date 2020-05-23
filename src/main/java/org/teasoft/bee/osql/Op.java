package org.teasoft.bee.osql;

/**
 * SQL语言的各种操作符.SQL's Operation Type.
 * @author Kingstar
 * @since  1.3
 */
//OperationType
public enum Op {

	/**
	 * eq is : =
	 */
	eq("="),
	
	/**
	 * gt is : >
	 */
	gt(">"),
	
	/**
	 * lt is : <
	 */
	lt("<"),
	
	/**
	 * nq is : !=
	 */
	nq("!="),   // <> 
	
	/**
	 * ge is : >=
	 */
	ge(">="),
	
	/**
	 * le is : <=
	 */
	le("<="),
	
	like(" like "),
	notLike(" not like "),
	
	in(" in"),
	notIn(" not in"),
	
	
	/**
	 * equal is : =
	 */
	equal("="),
	
	/**
	 * great than(same as gt) is : >
	 */
	greatThan(">"),
	
	/**
	 * less than(same as lt) is : <
	 */
	lessThan("<"),
	
	/**
	 * not equal(same as nq) is : !=
	 */
	notEqual("!="),   // <> 
	
	/**
	 * great equal(same as ge) is : >=
	 */
	greatEqual(">="),
	
	/**
	 * less equal(same as le) is : <=
	 */
	lessEqual("<=");
	
//	not("!");   //????
	
	private String operator;
	
	Op(String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
}
