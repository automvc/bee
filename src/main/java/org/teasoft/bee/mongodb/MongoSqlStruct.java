/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.mongodb;

import java.io.Serializable;

/**
 * MongoSql struct for Mongodb SUID operate.
 * @author Kingstar
 * @since  2.0
 */
public class MongoSqlStruct implements Serializable{
	
	private static final long serialVersionUID = 1592803913614L;
	
	private String returnType;
	private Class entityClass;

	private String tableName;
//	Document filter;
//	Bson filter;
	private Object filter;

//	String group;
//	Bson sortBson; // orderyBy
	private Object sortBson; // orderyBy

	private Integer start;
	private Integer size;

	private String[] selectFields;
	private boolean hasId;
	
	private Object updateSetOrInsertOrFunOrOther;  //for UPDATE,insert,fun,or other

	private String sql;

	public MongoSqlStruct(String returnType, String tableName, Object filter, Object sortBson,
			Integer start, Integer size, String[] selectFields, boolean hasId,Class entityClass) {
		super();
		this.returnType = returnType;
		this.tableName = tableName;
		this.filter = filter;
		this.sortBson = sortBson;
		this.start = start;
		this.size = size;
		this.selectFields = selectFields;
		this.hasId = hasId;
		this.entityClass=entityClass;
	}
	
	public MongoSqlStruct(String returnType, String tableName, Object filter, Object sortBson,
			Integer start, Integer size, String[] selectFields, boolean hasId,
			Class entityClass, Object updateSetOrInsertOrFunOrOther) {

		this(returnType, tableName, filter, sortBson, start, size, selectFields, hasId,
				entityClass);
		this.updateSetOrInsertOrFunOrOther = updateSetOrInsertOrFunOrOther;
	}

	public String getSql() { // just for cache
		if (this.sql == null) sql = toSql();
		return sql;
	}

	private String toSql() {

		StringBuffer strBuf = new StringBuffer();

		strBuf.append("[table]: ");
		strBuf.append(tableName);
		strBuf.append(" , [where/filter]: ");
//		if (filter != null) strBuf.append(filter.toJson());
		if (filter != null) strBuf.append(filter.toString());
//		strBuf.append("[groupBy]: ");
//		strBuf.append(groupBy);
		strBuf.append(" , [orderyBy/sort]: ");
		if (sortBson != null) strBuf.append(sortBson.toString());
		strBuf.append(" , [skip]: ");
		strBuf.append(start);
		strBuf.append(" , [limit]: ");
		strBuf.append(size);
		strBuf.append(" , [selectFields]: ");
		if (selectFields != null) {
			for (int i = 0; i < selectFields.length; i++) {
				if (i != 0) strBuf.append(",");
				strBuf.append(selectFields[i]);
			}
		}
		strBuf.append(" , [returnType]: ");
		strBuf.append(returnType);
		strBuf.append(" , [entityClass]: ");
		if(entityClass!=null)
			strBuf.append(entityClass.getName());
		
		if(updateSetOrInsertOrFunOrOther!=null) {
			strBuf.append(" , [updateSet/insert/fun]: ");
			strBuf.append(updateSetOrInsertOrFunOrOther.toString());
		}

		return strBuf.toString();
	}
	
	public MongoSqlStruct copy() {
		return new MongoSqlStruct(this.returnType, this.tableName, this.filter, this.sortBson,
				this.start, this.size, this.selectFields, this.hasId, this.entityClass,
				this.updateSetOrInsertOrFunOrOther);
	}

	
	public String getReturnType() {
		return returnType;
	}

	public Class getEntityClass() {
		return entityClass;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public Object getFilter() {
		return filter;
	}

	public Object getSortBson() {
		return sortBson;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getSize() {
		return size;
	}

	public String[] getSelectFields() {
		return selectFields;
	}

	public boolean isHasId() {
		return hasId;
	}
	
	public Object getUpdateSetOrInsertOrFunOrOther() {
		return updateSetOrInsertOrFunOrOther;
	}

	//2.1 for Mongodb geo
	public void setFilter(Object filter) {
		this.filter = filter;
	}

}
