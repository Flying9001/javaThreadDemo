## javaThreademo  
    
    
java 多线程使用示例    

- 1 创建多线程的3种方式(实现`Runnable`接口,继承`Thread`类,实现`Callable`接口)  
  线程类: `com.ljq.utils.RunnableUtil`,测试类: `com.ljq.demo.RunnableDemo`  
  线程类: `com.ljq.utils.ThreadUtil`,测试类: `com.ljq.demo.ThreadDemo` 
  线程类: `com.ljq.utils.CallableCalculator`, 测试类: `com.ljq.demo.CallableCalculatorPoolDemo`  
    
- 2 创建线程池的两种方式(实现`Runnable`接口,实现`Callable`接口)  
  线程类: `com.ljq.utils.TaskRunnable` , 测试类: `com.ljq.demo.RunnablePoolDemo`  
  线程类: `com.ljq.utils.TaskCallable`, 测试类: `com.ljq.demo.FuturePoolDemo`  
  线程类: `com.ljq.utils.CallableCalculator, 测试类: `com.ljq.demo.CallableCalculatorPoolDemo`  
    
- 3 线程同步(`synchronized`)  
  线程类: `com.ljq.utils.SyncTask`, 测试类: `com.ljq.demo.ThreadsyncDemo`  






