package com.yangjiayu.transaction;

public interface TransactionDefinition {
    // 返回事务的传播行为
    int getPropagationBehavior();
    // 返回事务的隔离级别，事务管理器根据它来控制另外一个事务可以看到本事务内的哪些数据
    int getIsolationLevel();
    //返回事务的名字
    String getName();
    // 返回事务必须在多少秒内完成
    int getTimeout();
    // 返回是否优化为只读事务。
    boolean isReadOnly();

}
