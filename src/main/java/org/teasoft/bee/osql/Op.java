package org.teasoft.bee.osql;

/**
 * SQL's Operation Type.
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
	
	/**
	 * Like, the matching character is not limited to the left or right; Suitable for complex fuzzy queries.
	 * <br> it is necessary to judge whether the final character only contains matching characters ('%'and' _'); 
	 * <br> since from 1.17, the framework will do this kind of inspection;
	 * <br> since from 1.17, if can confirm whether the matching character is on the left or right, 
	 * <br> and can preferentially use likeLeft,likeRight,likeLeftRight.
	 */
	like(" like "),
	
	/**
	 * not like.
	 * <br>the user need escape the '%' and '_' in the parameter value.
	 * <br>column_name not like'aaaaaa'will find all column_name is not a record of 'aaaaaa'.
	 * <br>In the where condition, it is not recommended to use only the not like filter condition; 
	 * <br>It can be used in conjunction with other filtering conditions to prevent malicious SQL attacks.
	 */
	@Deprecated
	notLike(" not like "),
	
	/**
	 * Like left match, and the framework adds '%' to the left of the parameter value.
	 * <br> the value of the parameter will be escaped by the framework.
	 * <br> the value of the parameter cannot be empty.
	 * @since 1.17
	 */
	likeLeft(" like "),
	
	/**
	 * Like right match, and the framework adds '%' to the right of the parameter value.
	 * <br> the value of the parameter will be escaped by the framework.
	 * <br> the value of the parameter cannot be empty.
	 * @since 1.17
	 */
	likeRight(" like "),
	
	/**
	 * Like right match, and the framework adds '%' to the right of the parameter value.
	 * <br> the value of the parameter will be escaped by the framework.
	 * <br> the value of the parameter cannot be empty.
	 * @since 1.17
	 */
	likeLeftRight(" like "),
	
	
//	/**
//	 * not like ,and add '%' on the left of parameter.
//	 */
//	@Deprecated
//	notLikeLeft(" not like "),
//	/**
//	 * not like ,and add '%' on the right of parameter.
//	 */
//	@Deprecated
//	notLikeRight(" not like "),
//	
//	/**
//	 * not like ,and add '%' on the left and right of parameter.
//	 */
//	@Deprecated
//	notLikeLeftRight(" not like "),
	
	/**
	 * in
	 */
	in(" in"),
	
	/**
	 * not in
	 */
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
