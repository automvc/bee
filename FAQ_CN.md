Bee常见疑问收集:

1.

Q: Bee支持几种数据库?  

A: MySQL,MariaDB,Oracle,SQL Server,H2,SQLite,PostgreSQL等等都是支持的,只要该DB支持JDBC,Bee就可以轻松支持它!

2.

Q:&nbsp;表与实体Javabean可以自动映射吗?

A: Bee采用约定优于配置的方式,默认实现有三种方式, 且支持自定义映射规则扩展.  
在bee.properties作相关配置即可切换默认实现方式.

```properties
#since 1.7.2
#default implement translate type. 1 : order_no<-->orderNo(DB<-->Java), 2: ORDER_NO<-->orderNo(DB<-->Java), 3: original
#if want to use other naming rule, you can define a new class implements NameTranslate
#default value is :1
bee.osql.naming.translateType=1
```
一般情况下,字段命名转换,MySQL设置为1, Oracle设置为2.  

3.

Q:&nbsp;Bee支持读写分离,支持多数据源吗?

A: V1.8支持读写分离一主多从, 仅分库等多数据源模式。  
分布式环境下生成连续单调递增(在一个workerid内),全局唯一数字id。

4.    
    

Q: 在一个DB中，随着数据量不断增长，需要将老的数据移到历史表中. 如，订单表orders,将5月，6月数据移到 orders\_202005,orders\_202006,结构与表orders一样。 如何用同一Javabean，同时映射多个数据表？

A:&nbsp;V1.8支持同库分表,动态表名映射.&nbsp;

参考:&nbsp;[https://gitee.com/automvc/bee/issues/I1P8YH](https://gitee.com/automvc/bee/issues/I1P8YH)&nbsp;

或:&nbsp;[https://github.com/automvc/bee/issues/18](https://github.com/automvc/bee/issues/18)

5.

Q: Bee有说明文档吗?有测试用例吗?这么好用的orm竟然没文档??!!!

A: 请参考Bee源码网站wiki,或: JavaWeb开发的利器 系统文章，请关注微信公众号: 软件设计活跃区. 测试用例,请查看:[https://gitee.com/automvc/bee-exam](https://gitee.com/automvc/bee-exam)

6.    
    

Q: 请教下bee的多对多映射是类似mybatis那种可以全部查出来然后映射，还是hibernate那种多次查询?

A: bee更接近原生SQL,可用原生语句分页，不需要全部查出来，也不需要查多次 wiki相关文档: (四): 分页、查询部分字段原来如此简单 (六): 多表查询(面向对象方式)

7.    
    

Q: Bee怎么具有AI特性?

A: 通过从手工写sql语句直接用JDBC操作数据库，到简单的DB工具类， 再到像Hibernate的旧版本通过操作对象将操作DB封闭到Dao； 再到后来写dao都觉得累赘，通用操作只写个空接口。 ORM工具的发展，就是一步一提炼，简化操作的历史。 假如用AI学习，演变，那写空接口都会觉得是多余的，&nbsp;每个数据库表不就是表名,以及包含一些列而矣吗??!!!&nbsp;为什么不能用同样的方式去处理呢??!!!&nbsp;而且dao层可以直接去掉放到ORM框架统一处理。 为了实现这些目标,就有了Bee框架。 原来编码复杂度是O(n)的，现在变成是O(1),无论多少个表,你都可以不用另外再写dao代码。 可以用时间复杂度和空间复杂度体会下编码复杂度这种变化。

8.    
    

Q:&nbsp;分布式ORM正在解决的问题之一: 能不能找到一种，既不依赖DB，也不依赖时间的ID生成算法呢？ DB表自增ID真的不能用在分布式场景吗？

A: 都是可以的.参考Bee的org.teasoft.bee.distribution.GenId接口的三种实现.

9.    
    

Q:&nbsp;与传统ORM工具的比较?

A: Hibernate的概念太复杂，学习成本高，更新会先查询再更新，n+1问题。Mybatis即使进行单表的Suid操作也需要人工写sql或生成sql文件，需要维护的sql太多。 更多比较,参考:&nbsp;[https://blog.csdn.net/abckingaa/article/details/84557336](https://blog.csdn.net/abckingaa/article/details/84557336)

10.    
    

Q:&nbsp;Bee如何提高Java web软件开发效率?  
自动生成Javabean实例,自动生成Controller类实例  

A: 除了可以不需要写dao代码外(编码复杂度为O(1)),还提供了表对应的实体Javabean自动生成工具, 根据模板自动生成Java web前后端代码;人性化的SQL日志,可输出直接运行的sql语句(有占位符的SQL不能直接运行,不方便调试).  
bee-exam工程,org.teasoft.exam.bee.osql.autogen包下:  
GenBeanExam.java Javabean生成实例  
GenFilesExam.java SpringMVC Rest Controller生成实例  

11.    
    

Q:&nbsp;Bee支持缓存吗? 如何设置缓存?	

A: 支持。还可以像调优JVM一样，对一级缓存进行调优。有暂时缓存，也有永久缓存，还有可以同步更新的永久缓存。	

```properties
#cache=======================start
#缓存类型
#bee.osql.cache.type=FIFO
#缓存集数据量数目
bee.osql.cache.mapSize=10
#resultset超过一定的值将不会放缓存
bee.osql.cache.workResultSetSize=300
#缓存保存时间(毫秒 ms)
bee.osql.cache.timeout=3000
#检测到超时,超过这个使用比例则顺便起线程清除缓存
bee.osql.cache.startDeleteRate=0.6
#缓存容量使用率;添加缓存,检测达到该使用率则清除一定比例缓存
bee.osql.cache.fullUsedRate=0.8
#添加缓存,检测到缓存容量快满时,删除缓存数的比例
bee.osql.cache.fullClearRate=0.2

#仅分库时(bee.dosql.multiDS.type=2),可用格式:  dsName.tableName
#use table name, not entity name
#不缓存表的列表, 表名不区分大小写.视图强烈建议不放缓存,因会产生脏数据.
#bee.osql.cache.never=user
#永久缓存表的列表, 表名不区分大小写
#bee.osql.cache.forever=constant
#只有更改时才会清除缓存,以便同步新的值到缓存. 表名不区分大小写
#bee.osql.cache.modifySyn=para

# since v1.7.2. default value is: false (use cache)
#bee.osql.cache.nocache=false

#since 1.8.99
bee.osql.cache.keyUseMD5=true
#cache=======================end
```

12.    
    

Q:&nbsp;Bee设计原理?

A: 参考wiki或公众号相关文章: (十一)：如何设计ORM架构及Bee源码分析 (十二)：为什么需要一个新的ORM框架

13 (1).Q:&nbsp;Bee查询怎么写筛选条件(不是等号=的情况)呢？像筛选状态大于2的 ?   还有 update高级用法

A: 写法类似： Condition condition=new ConditionImpl(); condition .op("status", Op.gt, 2) // 会转化到SQL中的where status&gt;2 详情参考wiki: (五): 复杂查询(面向对象方式) (十三)：update高级用法说明    
 **更新的字段是在原来的基础上变化** 
如某类商品提价2元，可以有如下写法。    
set price=price+2    
 **这样写的好处，可以不需要查询出原来的价格，减少IO开销。**     
Bee的面向对象写法：    
condition.setAdd("price", 2);     
suidRich.update(entity,condition);    

若字段p每次增加的值由字段step配置，则写为：    
condition.setAdd("p", "step");    
会转化为: set p=p+step	

13 (2). Q:&nbsp;SuidRich接口,update方法,如何区分SQL的set部分和where部分? 即哪些字段会用在set设置部分,哪些字段会用在where条件过虑部分?

A: 当更新一个实体,是根据id来唯一关联一个实体时,用Suid接口的update(T entity)方法即可,该方法以id作为where条件,其它非null,非空字段转为要更新的值.
默认转换的如改价格, set price=22; 但要是比原价提高2,set price=price+2,此时不能通过将值放在实体进行默认转换,需要借助Condition,用:condition.setAdd("price", 2);   
若用id可以唯一关联一个实体,可用:
updateById(T entity,Condition condition);
 * SQL UPDATE语句包括两大部分SET和WHERE,SuidRich采取指定其中一样,另一样尽量采用默认的实现方式.所以有关更新的方法分为两部分:
 * <br>update和updateBy.
 * <br>update方法中,String updateFields参数(若有),可以指明要更新的字段,其余字段则有可能转为SQL UPDATE语句的WHERE部分(默认过
 * <br>滤NULL和空字符串,可通过IncludeType显示设置).
  * <br>updateBy方法中,String whereFields(若有),可以指明用于SQL中WHERE的字段.当指定了whereFields, 没在whereFields的字段,将默认
 * <br>转换为SQL UPDATE语句的SET部分(默认过滤NULL和空字符串,可通过IncludeType显示设置).
 * <br>同一个实体的某个属性的值,若用于WHERE部分了,再用于UPDATE SET部分就没有意义(因为此时它们的值是一样的),但可以用Condition的
 * <br>set(String fieldName, Number num)等方法设置;Condition的方法set,setMultiply,setAdd,setWithField,是在处理WHERE字段前
 * <br>已完成处理的,所以不受指定的WHERE条件字段的影响.
 * 
 * <br>update和updateBy方法的Condition设置的字段都会被解析,不受IncludeType的限制,也不受updateFields参数和whereFields参数的影响.

14.Q:&nbsp;Bee与Honey是什么关系? 

A: ORM Bee框架是采用接口与实现分离的设计方式.Bee是接口,而Honey则是Bee的实现.	

14-2. Q: Bee开源的代码都是接口定义吗 没有实现吗？ 

A: 接口与实现分离. 使用API可只关注接口.  
Bee是接口, Honey是实现, Bee-ext是涉及第三方的扩展实现(可能会用到) 

15.

Q:&nbsp;Bee非常易用,编写代码少,但使用是一方面, 它的性能如何?

A: 性能绝对是过得去的．README给出了详细的表格比较数据．　　详细比较还开启了一个项目，欢迎ＰＫ。  
https://gitee.com/automvc/orm-compare  

16.

Q:&nbsp;Bee适合手机开发领域吗?

A: Bee文件小。bee V1.8 jar files 仅217k. 而且性能也接近JDBC的性能.还专门对H2,SQLite作了优化.

17.    
    

Q: 如何自动填日期字段?  

A: Bee默认不解析是null或空的字段；  
当Javabean的日期是null时，Bee不会解析. 像mysql可以在DB端自动触发填充日期值。  

18. 

Q: Bee对Excel导入有什么支持? 有简化操作吗?  

A: 轻松用ORM Bee实现将Excel的数据转成List<String[]>,并导入到数据库。  
读取最简单的就一行代码:　List<String[]> list = ExcelReader.readExcel("D:\\test-dataType.xlsx");  
参考bee-exam项目里:  
ExcelReaderTest.java  
ImportExcelTest.java  
八行代码搞定将excel数据导入到DB  
https://blog.csdn.net/abckingaa/article/details/113603130  
或:  
https://my.oschina.net/u/4111850/blog/4944468  

19.

Q: 没有与表对应的实体Javabean，如何操作数据?  
A: 用map进行转换实体信息，查询/删除数据库中的数据.  
参考bee-exam项目里:  
MapSuidExam  

```java
			MapSuid mapSuid = BeeFactoryHelper.getMapSuid();
			MapSql mapSql = BeeFactoryHelper.getMapSql();

		    mapSql.put(MapSqlKey.Table, "test_user");
//			mapSql.put(MapSqlKey.Table, "testUser");
			mapSql.put(MapSqlKey.SelectColumns, "name,password");
			mapSql.put(MapSqlKey.OrderBy, "name");
			
			mapSql.put(MapSqlSetting.IsNamingTransfer, true);
//			mapSql.put(MapSqlSetting.IsIncludeEmptyString, true);
			mapSql.put(MapSqlSetting.IsIncludeNull, true);

			mapSql.put("name", "Bee");
			mapSql.put("email", ""); //emptyString
			mapSql.put("lastName", null);
//			mapSql.put("last_name", null);

			String json = mapSuid.selectJson(mapSql);
			Logger.info(json);
//		    mapSuid.selectJson(mapSql); //test cache

			mapSuid.select(mapSql);
			mapSuid.select(mapSql);

			Map map = mapSuid.selectOne(mapSql);
			if (ObjectUtils.isNotEmpty(map)) {
				Logger.info(map.get("name").toString());
				Logger.info(map.get("password").toString());
			}
			mapSuid.selectOne(mapSql);     
```
       
20.

Q：表对应的实体Javabean有些字段不想解析,如何实现?  
A：
Ignore注解，忽略Javabean字段，不进行转换.  
但这种应尽量少用.  纯的Javabean，当DB有变动时，很容易就可以更改了,自动生成纯Javabean更方便,安全.  
Bee默认是不处理为null或空字符的字段的，因此，操作DB前将其置空即可.  

21.
How to use ORM Bee develop when the sql like: select examno, subject,max(score) ,avg(score) ,min(score) from scores?  
Detail see wiki:  
More SQL Function, more Group by  

```java
		Condition condition=new ConditionImpl();
		
		condition
		.selectField("classno,term,examno,subject")
		.selectFun(FunctionType.MAX, "score","maxScore")
		.selectFun(FunctionType.AVG, "score","avgScore")
		.selectFun(FunctionType.MIN, "score","minScore");
		
		condition.op("status", Op.nq, "FIN"); 
		
		condition
		.groupBy("term,examno,subjectno,subject")
		.orderBy("classno,term,examno,subjectno")
		;
		
		Scores scores=new Scores();
		String r=suidRich.selectJson(scores, condition); // json result
		System.out.println(r);
		
		List<String[]> listString=suidRich.selectString(scores, condition);  // string array result
		String str[];
		for (int i = 0; i < listString.size(); i++) {
			str=listString.get(i);
			for (int j = 0; j < str.length; j++) {
				System.out.print(str[j]+"     ");
			}
			System.out.println();
		}
```

22.

Q: Bee为什么没有findAll(),deleteAll()方法?  
A: 在一个系统里，几乎是不会有删除整个表的应用场景的。即使写demo样例也很少。所在Bee还特意加了一个检测开关，  
  以防止误删整个表的数据。 要是软删除(只标记一个字段状态表示不用该数据了),那直接用update就好了。  
  findAll()应用的场景也很有限，除了配置表，只存储少量记录，会查询所有数据；像用户表，订单表等是不可能查询所有数据的，  
  一般都是要分页(另外，Bee的分页功能比其它工具的都好用，性能也高)。在Bee,查询所有数据，类似用法如下:   
   suid.select(new ConstValue());//查询所有常量,假设表名对应的实体名为:ConstValue  


23.

Q: Bee为什么没有save方法?  
A: 别的ORM框架，将insert与update合为一个save方法，每次操作前都要查询一次数据，看数据库是否存在该记录，  
  以确定是要用insert还是update. 更新操作时，entity要设置id值，以便让查询确定该实体是否存在。  
  相当于更新操作，只能以id为where 条件,一次只能更新一条(有更新多条的需要时，这种做法效率不会高)。  
  当使用mysql数据库且JPA主键策略为@GeneratedValue(strategy = GenerationType.IDENTITY)，全局更新未带version数据时，  
  更新操作会变为保存操作。  
  但在很多业务场景，insert与update是明确可以区分开的，特别是在互联网应用。  
  要是用save反而会降低系统的性能。  
 
 **V1.9.8 , SuidRich有提供save方法。  
 如果可以区分开,建议明确调用insert(entity)或者update(entity),这样更加安全和高效。  

24.

Q:  Bee为什么不需要写mapper,dao?  
A:  这是Bee的一大优势，Bee的编码复杂度是O(1). Bee概念简单，易于使用，编码量少。  
    Bee通过约定优于配置原则,通过封装,已经简化了开发.  
 
25.

Q:  Bee一对多查询?  
A:  Bee一对多查询不需要List. 呈现方式,像我们用DB客户端查询数据,结果是一个二维表. Bee是将这个二维表的每一行封装  
在一个主对象里,每个主对象会有一个从对象保存从表的数据.  
详细例子可参考:
    https://gitee.com/automvc/bee/wikis/(%E5%85%AD):%20%E5%A4%9A%E8%A1%A8%E6%9F%A5%E8%AF%A2(%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E6%96%B9%E5%BC%8F)?sort_id=2309685

26.

Q:  多表关联时,一对多查询,字段类型用List?  
     
A:  当为了前端显示方便等原因,需要将从表数据作为主表的list属性时,可以用该功能.  
    V1.9.8有该功能支持,参考例子:  
https://gitee.com/automvc/bee-exam/blob/master/src/main/java/org/teasoft/exam/bee/osql/ListEntityTest.java  
    
27.

Q:  联合主键如何查询或更新记录?  
A:  Bee通过约定优于配置原则,约定主键名称是id,这样可以使问题变量简单,处理的效率也更高.  
	对于一些老的系统,有联合主键的,当作一般查询处理即可,即有两个字段作为主键,要用联合主键时,设置两个属性的值,框架就会负责解析(Suid的update方法,SuidRich的selectById等方法默认是id主键则不适用).  
	
28.

Q:  表主键名称不是id或id类型是String类型,如何处理?  
A:  Suid的update方法,SuidRich的selectById等方法默认是将id为会字段用于where条件,以便确认要修改的记录.  
没有id字段,则指定作为where的字段即可.如: suidRich.updateBy(noid, "uuid"); //noid为实体对象,"uuid"字段作为过滤的字段.  
以下为详细例子.  

 ```java 
 //Noid总共有以下4个字段.
//	private String uuid;
//	private String name;
//	private Integer num;
//	private String remark;
 
	public static void testNoId() {
		Noid noid=new Noid();
		noid.setUuid("aaaaaa-no-id");
		noid.setName("test no id");
		suid.insert(noid);
		
		List<Noid> list=suid.select(noid);
		Printer.printList(list);
		
		noid.setUuid("aaaaaa-no-id");
		noid.setName("new name3");
//		suid.update(noid);   //默认id作为where条件里的表达式,用于确定需要更新的记录
		suidRich.updateBy(noid, "uuid"); //没有id字段,则指定作为where的字段即可.
		
		List<Noid> list2=suid.select(noid);
		Printer.printList(list2);
	}
 ```
 
29.

Q:  表名与实体名、字段名与属性名映射默认提供多种实现，且支持自定义映射规则扩展。  请问这个是怎么设置的，谢谢。  
    How to set customized NameTranslate?   
A:  实现NameTranslate接口, 并在NameTranslateHandle类设置setNameTranslat(NameTranslate nameTranslat)  
    当前对象设置,参考第41.
30.

Q:  多表关联时,如何在SQL on部分加表达式,过滤数据?  
      
A:  使用Condition接口的opOn方法.
    public Condition opOn(String field, Op Op, Object value);  
    
31.

Q:  请问下Bee中批量更新是怎么处理的呢    
A:  update 不像insert 有批量的接口。  因为用同一条语句可以更新多条记录.  
如 update table_name set field1='abc' where field2='aa' and field3='bb',  
符合where条件的记录都将被更新.  
这种只用一条语句就可以更新多条记录,用SuidRich接口相关的update方法就好.  
要是确实要多个update，可以自己写一个循环， 然后用同一个connection连接，提交效率.  
beginSameConnection();  
//多个update语句  
endSameConnection();  

32.

Q:  在where条件里如何使用or  
      
A:  例子如下:

 ```java 
	condition
		.lParentheses()  // (
		.op("classno", Op.eq, "201")
		.or()
		.op("classno", Op.eq, "202")
		.rParentheses()  // )
		;
 ```
	
	会转化成:  (classno="201" or  classno="202")
	
	
33.

Q:  Bee多表关联查询, 用List和不用List的区别  
      
A:  参考:https://blog.csdn.net/abckingaa/article/details/119859192　　
   
@JoinTable(mainField="table_id", subField="table_id",subClass="Columns", joinType=JoinType.JOIN)
	private Columns columns; 
//	private List<Columns> list;

//注解里subClass属性,当两个实体在同一个包,包名,是可以省略的.


34.

Q:  Java ORM框架Bee如何使用事务  
      
A:  //单笔操作,默认自动提交事务

多笔操作要在一次事务提交，可使用：

 ```java 
 try {

          Transaction transaction=SessionFactory.getTransaction();
           transaction.begin(); //事务开始

           //......放多个操作在这

           transaction.commit();//提交事务,事务结束

 } catch (BeeException e) {
      Logger.error(e.getMessage());
      transaction.rollback();
    }
 ```
 
具体例子如下：

 ```java 
Transaction transaction=SessionFactory.getTransaction();
    try {

      transaction.begin();

      Suid suid = BeeFactory.getHoneyFactory().getSuid();

      User user=new User();
      user.setUsername("testuser");
      user.setPassword("bee-user");

      suid.insert(user);//insert 1

      Orders orders = new Orders();
      orders.setUserid("bee");
      orders.setName("Bee(ORM Framework)");
      orders.setTotal(new BigDecimal("91.99"));
      orders.setRemark("test transaction"); 
      orders.setSequence("");//empty String test

      suid.insert(orders); //insert 2

      transaction.commit();

      List<Orders> list = suid.select(orders); //可任意组合条件查询
      for (int i = 0; i < list.size(); i++) {
        Logger.info(list.get(i).toString());
      }

    } catch (BeeException e) {
     // e.printStackTrace();
      Logger.error(e.getMessage());
      transaction.rollback();
    }
 ```

35.

Q:  Java ORM框架Bee分页实例  
      
A:  分页实例如下(结合springMVC):  

分页相关的,只需要传页码和一页的数据条数;返回就返回一页的数据.  

 ```java 
	@RequestMapping("/list")
	public Result list(Orderhistory orderhistory,
	     @RequestParam(value = "page", defaultValue = "1", required = false) int page, 
		 @RequestParam(value = "rows", defaultValue = "20", required = false) int rows) {	
	 Result  result =new Result();
	  
	int total = objSQLRichService.count(orderhistory); //可以用上缓存,提交效率
	List<Orderhistory> list=objSQLRichService.select(orderhistory, (page-1)*rows, rows);
	result.setRows(list);
	result.setTotal(total);//返回的总数据条数,有些前端框架需要.
		
	 return result;
    }
 ```


36.

Q:  生成Javabean时,遇到Bee无法支持的类型,如何处理?  
      
A:  
private [UNKNOWN TYPE]TEXT testData;  
生成Javabean时,有[UNKNOWN TYPE], 则表示遇到了没能识别的类型.  
可以在相应文件里配置  
如:Oracle,  
在:  
jdbcTypeToFieldType-Oracle.properties  
文件里,配置:  
DATE=Timestamp
可以将DATE指定转换为:Timestamp  
Honey工程下,预设了部分文件  
jdbcTypeToFieldType-Oracle.properties  
jdbcTypeToFieldType-H2.properties  
jdbcTypeToFieldType-MySQL.properties  
jdbcTypeToFieldType-PostgreSQL.properties  
jdbcTypeToFieldType-SQLite.properties  
jdbcTypeToFieldType-MariaDB.properties  
jdbcTypeToFieldType.properties  
等等..  
jdbcTypeToFieldType.properties是默认的,不需要指定数据库名称.  
规则是:  
#jdbcTypeToFieldType-{DbName}.properties,会覆盖  
jdbcTypeToFieldType.properties相同key的值  
可以只在jdbcTypeToFieldType.properties放配置.  

37.

Q:  想问下如果我想查询某个字段值是空的记录该怎么调用suid呢？  
      
A: 例如,查email为空的用户信息.

```java
			 Condition condition10=BeeFactoryHelper.getCondition();
			 condition10.op("email", Op.eq, null);
			 List<TestUser> list10 = suid.select(new TestUser(), condition10);
			
```
 //转成的sql为:
 
```sql

select id,email,last_name,name,password,username,createtime from test_user where email is null

 ```
 
 //where email is not null
 使用:  condition11.op("email", Op.nq, null);
 
```java 
condition11.op("email", Op.nq, null);
//condition11.op("email", Op.notEqual, null); //或者用这个
 ```
 
38.

Q:  在Maven工程,使用Bee,编程时没有提示javadoc API信息.如何设置才可以?  
    Bee为什么没有显示Java API信息  
      
A: 因为maven只下载了jar包,没有下载源码文件.  
在IDE里,下载即可.  
如Eclipse里, 工程右击, Maven-->Download Sources.  
可在本地maven仓库验证,是否多了一个文件:bee-1.9.8-sources.jar  

39.

Q:  PreparedSql 是否支持多数据源?  
      
A: PreparedSql的方法中带有泛型T的是支持多数据源的; 没带有泛型的，在多数据源场景，会操作默认数据源。	

40.

Q:  自己定义了某种DB的方言,如DB2,如何设置到Bee?  
      
A: V1.11可以通过DbFeatureRegistry设置,简单易用。	

41.

Q:  自己定义的命名转换器,如何设置  ?  
      
A: 全局NameTranslate设置,参考第29.
   V1.11支持在Suid等对象使用setNameTranslate方法设置命名转换器。	

 
其它:

Q:  多数据源如何配置(多数据源实例)?  
A:  相关用例可以查看,  
https://github.com/automvc/bee-exam  
或:  
https://gitee.com/automvc/bee-exam  
如:  
https://gitee.com/automvc/bee-exam/blob/master/src/main/java/org/teasoft/exam/bee/osql/ds/RwDsExam.java  
DiffDdExam.java  

若是用spring boot可参考:  
https://gitee.com/automvc/bee-starter-demo  


**其它相关资源:**

gitee issue:&nbsp;[https://gitee.com/automvc/bee/issues?assignee\_id=&amp;author\_id=&amp;branch=&amp;issue\_search=&amp;label\_name=&amp;milestone\_id=&amp;program\_id=&amp;scope=&amp;sort=&amp;state=closed](https://gitee.com/automvc/bee/issues?assignee_id=&amp;author_id=&amp;branch=&amp;issue_search=&amp;label_name=&amp;milestone_id=&amp;program_id=&amp;scope=&amp;sort=&amp;state=closed)&nbsp;

gitee wiki:&nbsp;[https://gitee.com/automvc/bee/wikis](https://gitee.com/automvc/bee/wikis)

github issue:&nbsp;[https://github.com/automvc/bee/issues?q=is%3Aissue+is%3Aclosed](https://github.com/automvc/bee/issues?q=is%3Aissue+is%3Aclosed)&nbsp;

github wiki:&nbsp;[https://github.com/automvc/bee/wiki](https://github.com/automvc/bee/wiki)