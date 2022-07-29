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
	 * like.
	 * the user need escape the '%' and '_' in the parameter value.
	 */
	like(" like "),
	
	/**
	 * not like.
	 * the user need escape the '%' and '_' in the parameter value.
	 * column_name not like 'aaaaaa' 将会查出所有column_name不是aaaaaa的记录.有受攻击的危险.
	 */
	@Deprecated
	notLike(" not like "),
	
	/**
	 * like ,and add '%' on the left of parameter.
	 * <br>the value of parameter will be escaped.
	 */
	likeLeft(" like "),
	
	/**
	 * like ,and add '%' on the right of parameter.
	 * <br>the value of parameter will be escaped.
	 */
	likeRight(" like "),
	
	/**
	 * like ,and add '%' on the left and right of parameter.
	 * <br>the value of parameter will be escaped.
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
