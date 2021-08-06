### 查漏补缺

### 第6章 广播
广播分为两种：标准广播和有序广播。

创建receiver之后，清单文件中enable属性表示是否启用这个BroadcastReceiver，exported属性表示是否允许这个BroadcastReceiver接收本程序以外的广播。

不要在onReceiver()中添加过多的逻辑或者进行任何耗时操作，因为BroadcastReceiver中是不允许开启线程的。

在Android 8.0系统之后，所有隐式广播都不允许使用静态注册的方式来接收。这里隐式广播指的是那些没有具体制定发送给哪个应用程序的广播。
大多数系统广播属于隐式广播，但是少数特殊的系统广播目前仍然允许使用静态注册的方式来接收。
```kotlin
val intent = Intent("com.sesame.appcheck.broadcast.MY_BROADCAST")
intent.setPackage(packageName) // 指定这条广播是发给哪个应用程序的，从而让它变成一条显式广播。
sendBroadcast(intent)
```
