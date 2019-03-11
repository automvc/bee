package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.3
 */
//OperationType
public enum Op {

	/**
	 * eg is : =
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
	 * le is : <=
	 */
	le("<="),
	
	/**
	 * ge is : >=
	 */
	ge(">="),
	
	like(" like "),
	notLike(" not like "),
	
	in("in"),
	notIn("not in");
	
//	not("!");   //????
	
	private String operator;
	
	Op(String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
}
