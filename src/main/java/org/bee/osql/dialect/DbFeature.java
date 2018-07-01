package org.bee.osql.dialect;

/**
 * 为特定DB转换成对应的sql
 * @author KingStar
 * @since  1.0
 */
public interface DbFeature {
	public String toFromSql(String sql,int from,int size);
	public String toFromSql(String sql, int size);
}
