/*
 * Copyright 2013-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package org.teasoft.bee;

//import org.junit.Assert;
//import org.junit.Test;

/**
 * @author Kingstar
 * @since  1.7.2
 */
/*
public class BeeExam {
	
	@Test
	public void test(){
		
//		测试用例请查看工程:bee-exam 
//		以下任意一个地址：
//		https://gitee.com/automvc/bee-exam
//		https://github.com/automvc/bee-exam
//
//		让开发爱上测试，从Bee开始！
		
		boolean isFinished=false;
		
		System.out.println("测试用例请查看工程:bee-exam");
		System.out.println("以下任意一个地址：");
		System.out.println("https://gitee.com/automvc/bee-exam");
		System.out.println("https://github.com/automvc/bee-exam");
		System.out.println("");
		System.out.println("让开发爱上测试，从Bee开始！");
		System.out.println("");
		
		System.out.println("------------------------");
		System.out.println("");
//		test case see new project:bee-exam
//		url as below：
//		https://github.com/automvc/bee-exam
//		https://gitee.com/automvc/bee-exam
//
//		Let developers like test, starting with Bee!
		
		System.out.println("test case see new project:bee-exam");
		System.out.println("url as below：");
		System.out.println("https://github.com/automvc/bee-exam");
		System.out.println("https://gitee.com/automvc/bee-exam");
		System.out.println("");
		System.out.println("Let developers like test, starting with Bee!");
		
		isFinished=true;
		Assert.assertEquals(isFinished,true);
		
		
//		V1.11
//		2022-03-10 (yyyy-MM-dd)
//		Instructions Counters	
//		Element	   Coverage
//		Bee	        96.1%
//		Honey	    75.3%
//			
//		Method Counters	
//		Element	  Coverage
//		Bee	       92.2%
//		Honey	   83.6%
//			
//		Type Counters	
//		Element	  Coverage
//		Bee	       92.3%
//		Honey	   95.9%
		
//		V1.11
//		2022-03-02 (yyyy-MM-dd)
//		Instructions Counters	
//		Element	   Coverage
//		Bee	        95.5%
//		Honey	    75.1%
//			
//		Method Counters	
//		Element	  Coverage
//		Bee	       91.4%
//		Honey	   81.9%
//			
//		Type Counters	
//		Element	  Coverage
//		Bee	       92.5%
//		Honey	   96.5%
		
		
//		V1.9.8
//		2021-10-22 (yyyy-MM-dd)
//		Instructions Counters	
//		Element	   Coverage
//		Bee	        98.0%
//		Honey	    73.1%
//			
//		Method Counters	
//		Element	  Coverage
//		Bee	       97.5%
//		Honey	   78.2%
//			
//		Type Counters	
//		Element	  Coverage
//		Bee	       100.0%
//		Honey	   97.1%

//		V1.9.5
//		2021-04-01 (yyyy-MM-dd)
//		Instructions Counters	
//		Element	   Coverage
//		Bee	        96.7%
//		Honey	    73.1%
//			
//		Method Counters	
//		Element	  Coverage
//		Bee	       95.5%
//		Honey	   75.6%
//			
//		Type Counters	
//		Element	  Coverage
//		Bee	       100.0%
//		Honey	   93.8%
		
		
//		2021-03-20 (yyyy-MM-dd)
//		Instructions Counters	
//		Element	   Coverage
//		Bee	        91.6%
//		Honey	    65.6%
//			
//		Method Counters	
//		Element	  Coverage
//		Bee	       88.0%
//		Honey	   70.3%
//			
//		Type Counters	
//		Element	  Coverage
//		Bee	       97.0%
//		Honey	   86.3%
		
		
//		bee-exam last update time:2020-06-13 13:14 (yyyy-MM-dd HH:mm)
	  //add multi-DataSource support(Write/Read, only Split Database)
//		bee-exam last update time:2020-06-27 16:40 (yyyy-MM-dd HH:mm) 
		
//		bee-exam last update time:2020-07-26 22:53 (yyyy-MM-dd HH:mm)
//		bee-exam last update time:2020-08-02 16:43 (yyyy-MM-dd HH:mm)
		
//		multi-DS:only more database
//		bee-exam last update time:2020-08-22 22:14 (yyyy-MM-dd HH:mm)
		
//		add H2,SQLite Support:
//		bee-exam(v1.8.15)-normal(H2)-2020-09-20 21.37.23.126.txt
//		bee-exam(v1.8.15)-normal(MySQL)-2020-09-20 18.28.31.764.txt
//		bee-exam(v1.8.15)-normal(SQLite)-2020-09-20 19.43.53.751.txt
		
//		add PostgreSQL Support:
//		bee-exam(v1.8.15)-normal(H2)-2020-10-01 17.50.37.507.txt
//		bee-exam(v1.8.15)-normal(MySQL)-2020-10-01 16.43.57.577.txt
//		bee-exam(v1.8.15)-normal(PostgreSQL)-2020-10-01 14.12.13.668-autoGenId.txt
//		bee-exam(v1.8.15)-normal(PostgreSQL)-2020-10-01 15.59.45.647.txt
//		bee-exam(v1.8.15)-normal(SQLite)-2020-10-01 19.16.47.115-autoGenId.txt
//		bee-exam(v1.8.15)-normal(SQLite)-2020-10-01 19.19.10.831.txt 
		
//		Support lower and upper case option for SQL KeyWord:
//		bee-exam(v1.8.99)-normal(MySQL)-2020-10-17 21.41.40.37.txt
//		bee-exam(v1.8.99)-normal(MySQL)-2020-10-17 21.42.02.730-UPPER.txt

//		Optimize the way of setting DB information with Honeyconfig:
//		bee-exam(v1.8.99)-normal(MySQL)-2020-10-24 21.40.20.605.txt
		
//		V1.9
//		bee-exam(v1.9)-normal(MySQL)-2020-12-29 14.59.21.09.txt
//		bee-exam(v1.9)-normal(MySQL)-2021-01-17 23.52.19.330.txt
//		bee-exam(v1.9)-normal(MySQL)-2021-02-07 11.56.33.739.txt
//		bee-exam(v1.9)-normal(MySQL)-2021-02-14 10.11.34.561.txt
//		bee-exam(v1.9)-normal(MySQL)-2021-03-11 08.47.40.114.txt
//		bee-exam(v1.9)-cache-2021-03-11 08.52.07.423.txt
		
//		bee-exam(v1.9)-normal(Oracle)-2021-03-20 20.01.44.213.txt
//		bee-exam(v1.9)-cache(Oracle)-2021-03-20 20.02.02.758.txt
//		bee-exam(v1.9)-normal(MySQL)-2021-03-20 23.10.06.324.txt
//		bee-exam(v1.9)-cache(MySQL)-2021-03-20 23.10.16.346.txt
//		bee-exam(v1.9)-normal(SQLite)-2021-03-24 22.10.08.975.txt
		
//      test V1.9 with well-known and major database 
//		bee-exam(v1.9)2021-03-25 13.10.37.514-normal(Microsoft SQL Server).txt
//		bee-exam(v1.9)2021-03-25 13.14.57.616-normal(SQLite).txt
//		bee-exam(v1.9)2021-03-25 13.17.51.312-normal(MySQL).txt
//		bee-exam(v1.9)2021-03-25 13.20.15.761-normal(Oracle).txt
//		bee-exam(v1.9)2021-03-25 13.23.08.180-normal(H2).txt
//		bee-exam(v1.9)2021-03-25 13.25.51.23-normal(PostgreSQL).txt
		
//		bee-exam(v1.9)2021-04-01 21.32.08.537-normal(MySQL).txt
//		bee-exam(v1.9)2021-04-01 21.32.24.79-normal(Oracle).txt
//		bee-exam(v1.9)2021-04-01 21.32.47.917-normal(SQLite).txt
//		bee-exam(v1.9)2021-04-01 21.33.04.663-normal(H2).txt
//		bee-exam(v1.9)2021-04-01 21.33.08.408-normal(PostgreSQL).txt
//		bee-exam(v1.9)2021-04-01 21.33.20.953-normal(Microsoft SQL Server).txt
		
//		bee-exam(v1.9)2021-04-03 21.55.13.02-normal(MySQL).txt
//		bee-exam(v1.9)2021-04-03 21.55.27.357-normal(Oracle).txt
//		bee-exam(v1.9)2021-04-03 21.55.51.369-normal(SQLite).txt
//		bee-exam(v1.9)2021-04-03 21.56.05.780-normal(H2).txt
//		bee-exam(v1.9)2021-04-03 21.56.10.191-normal(PostgreSQL).txt
//		bee-exam(v1.9)2021-04-03 21.56.22.701-normal(Microsoft SQL Server).txt
//		bee-exam(v1.9)2021-04-03 21.56.30.119-cache(MySQL).txt
		
//		bee-exam(v1.9)2021-04-08 00.22.59.444-normal(MySQL).txt
//		bee-exam(v1.9)2021-04-08 00.23.12.834-normal(Oracle).txt
//		bee-exam(v1.9)2021-04-08 00.23.36.883-normal(SQLite).txt
//		bee-exam(v1.9)2021-04-08 00.23.52.876-normal(H2).txt
//		bee-exam(v1.9)2021-04-08 00.23.57.141-normal(PostgreSQL).txt
//		bee-exam(v1.9)2021-04-08 00.24.08.533-normal(Microsoft SQL Server).txt
//		bee-exam(v1.9)2021-04-08 00.24.15.820-cache(MySQL).txt
//
//		bee-exam(v1.9)2021-05-02 02.53.30.778-normal(MySQL).txt
//		bee-exam(v1.9)2021-05-02 02.53.47.666-normal(Oracle).txt
//		bee-exam(v1.9)2021-05-02 02.54.08.829-normal(SQLite).txt
//		bee-exam(v1.9)2021-05-02 02.54.26.717-normal(H2).txt
//		bee-exam(v1.9)2021-05-02 02.54.34.977-normal(PostgreSQL).txt
//		bee-exam(v1.9)2021-05-02 02.54.55.328-normal(Microsoft SQL Server).txt
//		bee-exam(v1.9)2021-05-02 02.55.16.45-cache(MySQL).txt

//      test for 1.9.8
//		bee-exam(v1.9.8)2021-10-22 13.28.59.122-normal(MySQL).txt
//		bee-exam(v1.9.8)2021-10-22 13.29.18.02-normal(Oracle).txt
//		bee-exam(v1.9.8)2021-10-22 13.29.41.620-normal(SQLite).txt
//		bee-exam(v1.9.8)2021-10-22 13.30.00.709-normal(H2).txt
//		bee-exam(v1.9.8)2021-10-22 13.30.07.72-normal(PostgreSQL).txt
//		bee-exam(v1.9.8)2021-10-22 13.30.26.941-normal(Microsoft SQL Server).txt
//		bee-exam(v1.9.8)2021-10-22 13.30.36.536-normal(MySQL).txt
//		bee-exam(v1.9.8)2021-10-22 13.30.58.799-cache(MySQL).txt

//      test for 1.11
//		bee-exam(v1.11)2022-03-02 11.12.43.273-normal(MySQL).txt
//		bee-exam(v1.11)2022-03-02 11.13.02.887-normal(Oracle).txt
//		bee-exam(v1.11)2022-03-02 11.13.31.975-normal(SQLite).txt
//		bee-exam(v1.11)2022-03-02 11.13.52.112-normal(H2).txt
//		bee-exam(v1.11)2022-03-02 11.13.58.850-normal(PostgreSQL).txt
//		bee-exam(v1.11)2022-03-02 11.14.12.619-normal(Microsoft SQL Server).txt
//		bee-exam(v1.11)2022-03-02 11.14.21.41-normal(MySQL).txt
//		bee-exam(v1.11)2022-03-02 11.14.45.538-cache(MySQL).txt

//		bee-exam(v1.11)2022-03-10 11.43.30.334-cache(MySQL).txt
//		bee-exam(v1.11)2022-03-10 11.43.12.658-normal(MySQL).txt
//		bee-exam(v1.11)2022-03-10 11.43.05.81-normal(Microsoft SQL Server).txt
//		bee-exam(v1.11)2022-03-10 11.42.48.444-normal(PostgreSQL).txt
//		bee-exam(v1.11)2022-03-10 11.42.41.610-normal(H2).txt
//		bee-exam(v1.11)2022-03-10 11.42.19.602-normal(SQLite).txt
//		bee-exam(v1.11)2022-03-10 11.41.53.808-normal(Oracle).txt
//		bee-exam(v1.11)2022-03-10 11.41.36.406-normal(MySQL).txt



	}
}
*/
