## 一、数据结构与算法

## 二、JVM内存模型与GC优化
#### 1、内存模型相关：
* JVM内存模型三个特性：原子性、可见性、有序性；volatile解决可见性和有序性，不解决原子性；
* volatile实现原理：靠读写屏障load，write barrier（内存屏障）
    * 1）阻止指令屏障两侧重排，
    * 2）强制刷脏，高速缓存和主存一致；
    * 3）触发mesi协议，总线嗅探机制：
* JVM内存五大区域：程序计数器、Java栈（虚拟机栈）、本地方法栈、堆、方法区；TLAB；
#### 2、GC相关：
* 堆区：新生代；老年代；永久区；
* 算法：标记-清楚、标记-复制、标记-整理；
* 对象存活判断：引用计数、可达性分析（GCRoot，三色标记）；
    * GCRoot四种对象：1）虚拟机栈引用对象、2）本地方法栈引用、3）方法区静态变量引用、4）方法区常量引用；
    * 三色标记：黑、灰、白；
        * 问题：多标、漏标；多标或者漏标问题如何解决；三个条件并发产生漏标需要解决，通过三道屏障；
        * cms：增量更新；G1：原始快照；ZGC：染色指针
* 年轻代采用复制算法（存活率低）、老年代采用标记清除、标记整理（存活率高，没有额外空间做担保，必须使用这两种算法）
* CMS回收器的问题：
    * 1）并发抢占CPU资源，
    * 2)三色标记-多标情况-产生浮动垃圾；
      处理办法CMSInitiatingOccupancyFraction 设置小一些提前回收，
      如果设置过大回收过晚导致Concurrent  Mode Failure，备案触发Serial Old，STW变长
    * 3）标记清除算法导致内存碎片过多；
      处理办法UseCMSCompactAtFullCollection、CMSFullGCsBeforeCompaction，控制full GC时压缩和压缩频率
* G1回收器的问题：
    * -XX:MaxGCPauseMillis，最大停顿毫秒数
    * -XX:GCPauseIntervalMillis，停顿间隔
    * -XX:+G1HeapRegionSize， 每个regon大小
* CMS于G1区别：
    *  1）内存模型（分代，分regon）、
    *  2）垃圾回收算法、
    *  3）处理三色标记漏标方式不同、
    *  4）垃圾回收过程不同、
    *  5）STW时间可控性。

### 参考资料
* jvm内存模型，作用：
https://www.jianshu.com/p/76959115d486
* JVM对象分配过程：
https://blog.csdn.net/yunxing323/article/details/109554454
* 三色标记相关问题：
https://baijiahao.baidu.com/s?id=1715966914701534617&wfr=spider&for=pc   染色指针是啥？
* G1回收器参数：
https://zhuanlan.zhihu.com/p/382554001
* 字符串在堆内存中如何存储：
https://mp.weixin.qq.com/s/bVSMSd606UdR2aBD1YJtJw
* 类加载机制，过程，双亲委派模式：
https://mp.weixin.qq.com/s/Itx7njbGQOqsOGTI0kfPAQ
https://blog.csdn.net/u011080472/article/details/51332866

## 三、设计模式

## 四、JDK基础（JUC）

## 五、数据库优化
#### 1、事务与锁
* 数据库分层：链接层、服务器层、存储引擎层。
* 数据库事务特性：ACID，A:undo log, D:redo log, I:MVCC, C；MVCC：隐藏列指向undo log指针
* 隔离级别：读未提交，读已提交，重复读，串行化；脏读，不可重复读，幻读；

#### 2、索引与优化
* 为啥使用B+树：
    `数据存储在叶子节点并且指针相连，避免磁盘随机IO`
*   

#### 3、分库分表

### 参考资料
* 数据库事务，隔离级别，传播行为：
  https://mp.weixin.qq.com/s/51vyvMdMnin6yD7MVXHG5w
  https://www.jianshu.com/p/aa76625d3715
* MVCC原理：https://zhuanlan.zhihu.com/p/64576887  
* 数据库索引：
  https://mp.weixin.qq.com/s/L0BtsXoJ1AB_tSLxMUbrOA
* sql索引分析：
  https://mp.weixin.qq.com/s?__biz=MzkzNTM1MDI4MQ==&mid=2247496930&idx=1&sn=0b10bac1a5763fda3db09f8ba6d49b1b&source=41#wechat_redirect
  https://mp.weixin.qq.com/s/oWNrLHwqM-0ObuYbuGj98A
* SQL优化，SQL执行流程；
  https://mp.weixin.qq.com/s/oS57PB2coco3kkUMyrgbEQ
  https://mp.weixin.qq.com/s/itef7dRove78ayKLU5yMlw

* 数据库分库分表；https://www.cnblogs.com/leeSmall/p/9539370.html




## 六、缓存Redis

## 七、限流
#### 1、限流原理
* 1）滑动窗口限流：
  `注意切分窗口大小`
* 2）漏斗限流：
  `恒定流出，可用队列实现，应用对数据库保护等，不使用突发流量场景，问题，突发流量导致大量请求拒绝`
* 3）令牌桶限流：
  `恒定流入，可应对一些突发流量，应用秒杀等场景`

#### 2、常用组件
* 1）Guaua Limit
* 2）Sentinel
RequestLimiter -> 
  LeapArray<T>.currentWindow() -> 
    WindowWarp<T>
   { long windowLengthInMs; // 窗口长度 long windowStart; // 窗口起始时间 T value; // 窗口数据统计}
  
### 参考资料
* Sentinel 滑动窗口数据采集原理：
  https://www.cnblogs.com/magexi/p/13124870.html
* Sentinel 简单介绍：
  https://www.jianshu.com/p/059aaf9492b1
* 限流方案：
  https://blog.csdn.net/asd1126163471/article/details/124054502

## 八、消息队列

## 九、搜索引擎ES

## 十、运维Shell，K8s

## 十一、分布式、微服务架构

