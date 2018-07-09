
Bee
=========
**Bee** is an ORM framework.  
**Honey** is the implementation of the Bee.  
**Bee** see:  
https://github.com/automvc/bee  
**Honey** see:  
https://github.com/automvc/honey  


## Requirement  
jdk1.7+

## Function: 

**Bee** is **Sea** (Simple, Easy, Automatic) style ORM framework.  
**V1.0**  
Single entity Suid (select,update,insert,delete) object-oriented operation.  
Automatically generate the Javabean via DB table or view(MySQL,MariaDB).  
Javabean no annotation,no xml.  
Automatically mapping the table column and the javabean field.  
Javabean support the raw type:int,double,and so on.  
PreparedStatement support.  
Procedure support.  
Native SQL support.  
Batch operate support.  
Transaction support.  
Automatic filter the null and empty field for default.  
MAX,MIN,SUM,AVG,COUNT support.  
Order by,Paging.  
Select some field.  
Dynamic & random combination of query conditions,no need to prepare the interface in advance; new query requirements, no need to change the query interface.  
All suid(select,update,insert,delete) operation use the same bee interface,no longer need any new one.  
Users/Developer only need to pay attention to the Bee interface.


Quick Start:
=========	
## 1. Create the database and the table  

Create one database,default name is bee.  
Create the table and init the data by run the bee.sql file(it is mysql sql script).  

## 2. Update the database configuration in bee.properties if need  

bee.db.driverName = com.mysql.jdbc.Driver  
bee.db.url =jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8  
bee.db.username = root  
bee.db.password =  

## 3. Run the following java code  

```java
		
	public static void main(String[] args) {
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee--ORM Framework");
		
		List<Orders> list1 =suid.select(orders1);  //select
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}
		
		orders1.setName("Bee(V1.0)--ORM Framework");
		int updateNum=suid.update(orders1);   //update
		System.out.println("update record:"+updateNum);
		
		Orders orders2=new Orders();
		orders2.setUserid("client01");
		orders2.setName("ORM book");
		orders2.setTotal(new BigDecimal(91));
		orders2.setRemark("");  //empty String test
		
		int insertNum=suid.insert(orders2); //insert
		System.out.println("insert record:"+insertNum);
		
		int deleteNum=suid.delete(orders2);   //delete
		System.out.println("delete record:"+deleteNum);
		
		List<Orders> list2 =suid.select(orders1); //select  confirm the data
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}
	}
```


#### Author's email:    honeysoft@126.com  
