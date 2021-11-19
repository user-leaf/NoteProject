# 说明
本例子要展示的是进程间通信，客户端输入两个数字a和b，服务端返回a和b的计算结果。

# AndroidIPC 机制
https://github.com/leavesC/IPCSamples/blob/master/note/AndroidIPC%E6%9C%BA%E5%88%B6%EF%BC%883%EF%BC%89-AIDL.md

# aidl流程
看官方文档  https://developer.android.google.cn/guide/components/aidl?hl=zh_cn#Defining

【我】还是看官方文档吧，比较清晰，还能涉及到别的有用的内容。
【我】java文件和aidl文件是不一样的，不能相互调用，编译一下aidl文件会生成相应的java文件。
【我】定义好的aidl文件，服务端和客户端是一模一样的，包名也得一样，不然生成的相应的java文件就不一样。是我定义的包名不太好，看起来不太"一致"。
