Android环境使用Bee

1.  bee.properties

```properties
bee.db.isAndroid=true
bee.db.androidDbName=account.db
bee.db.androidDbVersion=1
bee.osql.loggerType=androidLog
#开启查询结果字段类型转换,将支持更多类型
bee.osql.openFieldTypeHandler=true

#如果允许删除和更新整张表,需要开启
#bee.osql.notDeleteWholeRecords=false
#bee.osql.notUpdateWholeRecords=false
bee.osql.openFieldTypeHandler=true

```

2.实现app安装及升级需要创建和更新的表

```java
public class YourAppCreateAndUpgrade implements CreateAndUpgrade{
    @Override
    public void onCreate() {
//        可以使用面向对象方式创建表
        Ddl.createTable(new Orders(), false);
        Ddl.createTable(new TestUser(), false);
    }

    @Override
    public void onUpgrade(int oldVersion, int newVersion) {
        if(newVersion==2) {
            Ddl.createTable(new LeafAlloc(), true);
            Log.i("onUpgrade", "你在没有卸载的情况下，在线更新到版本:"+newVersion);
        }
    }
}


```

3.将YourAppCreateAndUpgrade和Android上下文注册到Bee     并在AndroidManifest.xml,配置android:name为BeeApplication

```java
package com.aiteasoft.util;

import org.teasoft.bee.android.CreateAndUpgradeRegistry;
import org.teasoft.beex.android.ApplicationRegistry;

public class BeeApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
       ApplicationRegistry.register(this);//注册上下文
       CreateAndUpgradeRegistry.register(YourAppCreateAndUpgrade.class);
    }
 }
 
// 并在AndroidManifest.xml,配置android:name为BeeApplication 
 <application
        android:icon="@drawable/appicon"
        android:label="@string/app_name"
         android:name="com.aiteasoft.util.BeeApplication"
       >

```

4. Java操作SQLite数据库与JavaWeb类似.    
操作数据库时, 不需要每次都传递Context到ORM框架.使用非常简单易用;性能也不差.
```java
Suid suid=BF.getSuid();
List<Orders> list = suid.select(new Orders()); 
```


对比:
其它Android ORM工具:    
需要用户为每个表封装dao.    
每次都要传递当前Activity。    
如:    
new UserDao(MainActivity.this).insert(userData);    
UserBean userBean = new UserDao(MainActivity.this).queryById(articleBean.getUser().getId());    
