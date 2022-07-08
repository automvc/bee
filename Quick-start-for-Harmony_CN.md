Harmony环境使用Bee入门向导  
​
一、添加jar包  

将bee相关的3个jar包复制到entry包下的libs目录，右击jar包，  

选择：Add as Libray...  ,  在跳出的对话框中选择ok.  


二、将相关配置注册到Bee  

在启动的Ability ，添加相应的配置和注册信息。 若有自定义的配置在bee.properties则需要;则需要使  用：BeeConfigInit.init();   

将上下文注册到Bee；将创建表和更新表的回调类,注册到Bee；  

以后就可以直接使用Bee了。  

```java

public class UserDataAbility extends Ability {
    private static final String TAG = UserDataAbility.class.getSimpleName();
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD000F00, TAG);
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        BeeConfigInit.init(); //若有自定义的配置在bee.properties则需要
        ContextRegistry.register(this.getApplicationContext()); //将上下文注册到Bee
        RdbOpenCallbackRegistry.register(new MyRdbOpenCallback()); //将创建表和更新表的回调类,注册到Bee
//      BeeRdbStoreRegistry.register(rdbStore);  //直接注册rdbStore对象也可以.  但需要自己去生成,配置信息也不好管理
    }
}
```

若有自定义的配置在bee.properties，将该文件放在entry\src\main\resources\rawfile目录下。


三、定义安装app时，创建表和更新表的类  

```java

package ohos.samples.dataability;

import ohos.data.rdb.RdbOpenCallback;
import ohos.data.rdb.RdbStore;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.samples.dataability.bee.entity.*;
import ohos.samples.dataability.entity.Person;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.HoneyContext;

public class MyRdbOpenCallback extends RdbOpenCallback {
    private static final String TAG = "MyRdbOpenCallback";
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD000F00, TAG);
    @Override
    public void onCreate(RdbStore store) {
        try{
            
//        store.executeSql(   //手动写sql
//                "create table if not exists " +  "person (user_id integer primary key autoincrement, "
//                        + "name text not null, "  + "age integer)");

            HiLog.info(LABEL_LOG,"--------------------创建表.......开始.");

            String sql= Ddl.toCreateTableSQL(new Person()); //不想写sql可以自动生成
            HiLog.info(LABEL_LOG, "---------------create table sql:"+sql);
            store.executeSql(sql);

            //创建表样例：
             store.executeSql(Ddl.toCreateTableSQL(new LeafAlloc()));
            store.executeSql(Ddl.toCreateTableSQL(new Orders()));
            store.executeSql(Ddl.toCreateTableSQL(new Tb_inaccount()));
            store.executeSql(Ddl.toCreateTableSQL(new Tb_outaccount()));
            store.executeSql(Ddl.toCreateTableSQL(new TestUser()));
         } catch (Exception e) {
           HiLog.error(LABEL_LOG, "---------------create table:"+e.getMessage());
        }
        HiLog.info(LABEL_LOG, "------------onCreate  finished!");
    }

    @Override
    public void onUpgrade(RdbStore store, int oldVersion, int newVersion) {
        HoneyContext.setCurrentAppDB(store);
        HiLog.info(LABEL_LOG,"--------------------更新表.......");
        HiLog.info(LABEL_LOG, "%{public}s", "DataBase upgrade");
        HoneyContext.removeCurrentAppDB();
    }

}
```
 

四，可以在其它AbilitySlice中使用Bee操作数据库了  

以下是select,update,insert,delete操作的例子。  

主要语句如下：  

```java

Suid suid = BF.getSuid();  //简单的select,update,insert,delete操作
suid.insert(p);
suid.delete(new Person(), condition);
suid.update(p); //根据id修改对象
list = suid.select(new Person());

```

//BF是BeeFactoryHelper的简称,也可以如下用法:
//Suid suid=BeeFactoryHelper.getSuid();  


详细代码如下：  

```java
    private void insert(Component component) {
        HiLog.info(LABEL_LOG, "----------------insert");
        try {
            Person p = new Person();
            p.setName(getRandomName());
            p.setAge(getRandomAge());
            suid.insert(p);
            HiLog.info(LABEL_LOG, "----------------insert结束.");
        } catch (Exception e) {
            HiLog.error(LABEL_LOG, "--------------insert--:" + e.getMessage());
        }
        query(true);
    }

    private void delete(Component component) {
        HiLog.info(LABEL_LOG, "----------------delete");

        try {
            Condition condition = BF.getCondition();
            condition.between("userId", 1, 2);
            suid.delete(new Person(), condition);
        } catch (Exception e) {
            HiLog.error(LABEL_LOG, "--------------insert--:" + e.getMessage());
        }
        query(true);
    }

    private void update(Component component) {
        HiLog.info(LABEL_LOG, "----------------update");
        try {
            Person p = new Person();
            p.setName("Tom_update");
            p.setAge(0);
            p.setUserId(1);
            suid.update(p); //根据id修改对象
        } catch (Exception exception) {
            HiLog.error(LABEL_LOG, "%{public}s", "update: dataRemote exception|illegalStateException");
        }
        query(true);
    }

    private void query(boolean queryAll) {
        HiLog.info(LABEL_LOG, "----------------query");

        getGlobalTaskDispatcher(TaskPriority.DEFAULT).asyncDispatch(() -> {
            List<Person> list = null;
            if (queryAll) {  //查所有
                list = suid.select(new Person());
            }else {
                list = suidRich.select(new Person(), 2, 5); //查从第2条开始的5条数据
            }
            appendText(list);
        });
    }
```

