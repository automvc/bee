package org.bee.osql;

/**
 * Object to SQL string for rich Suid
 * 
 * @author KingStar
 * @since  1.0
 */
public interface ObjToSQLRich extends ObjToSQL{

	public <T> String toSelectSQL(T entity,int size);
	public <T> String toSelectSQL(T entity,int from,int size);
	public <T> String toSelectSQL(T entity,String fieldList) throws ObjSQLException;
	
	public <T> String toUpdateSQL(T entity,String updateFieldList) throws ObjSQLException;
	public <T> String toUpdateSQL(T entity,String updateFieldList,IncludeType includeType) throws ObjSQLException;
	
	public <T> String toSelectFunSQL(T entity, String FieldForFun,FunctionType functionType) throws ObjSQLException;
	
	public <T> String toSelectOrderBySQL(T entity, String orderFieldList) throws ObjSQLException;
	public <T> String toSelectOrderBySQL(T entity, String orderFieldList,OrderType[] orderTypes) throws ObjSQLException;

	public  <T> String toSelectSQL(T entity, IncludeType includeType);
	public  <T> String toDeleteSQL(T entity, IncludeType includeType);
	public  <T> String toInsertSQL(T entity, IncludeType includeType);
	public  <T> String toUpdateSQL(T entity, IncludeType includeType);
	
	public  <T> String[] toInsertSQL(T[] entity);
	public  <T> String[] toInsertSQL(T[] entity,String excludeFieldList);
	
	
}
