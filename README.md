## javaThreademo  
    
    
java 多线程使用示例    

- 1 创建多线程的3种方式(实现`Runnable`接口,继承`Thread`类,实现`Callable`接口)  
  工作线程: `com.ljq.thread.RunnableUtil`,测试类: `com.ljq.demo.RunnableDemo`  
  工作线程: `com.ljq.thread.ThreadUtil`,测试类: `com.ljq.demo.ThreadDemo`  
  工作线程: `com.ljq.thread.CallableCalculator`, 测试类: `com.ljq.demo.CallableCalculatorPoolDemo`  
    
- 2 创建线程池的两种方式(实现`Runnable`接口,实现`Callable`接口)  
  工作线程: `com.ljq.thread.TaskRunnable` , 测试类: `com.ljq.demo.RunnablePoolDemo`  
  工作线程: `com.ljq.thread.TaskCallable`, 测试类: `com.ljq.demo.FuturePoolDemo`  
  工作线程: `com.ljq.thread.CallableCalculator`, 测试类: `com.ljq.demo.CallableCalculatorPoolDemo`  
    
- 3 线程同步(`synchronized`)  
  工作线程: `com.ljq.task.SyncTask`, 测试类: `com.ljq.demo.ThreadsyncDemo`  
    
- 4 线程之间通讯(Thread signaling)  
  工作线程: `com.ljq.task.PrintTask`, 测试类: `com.ljq.demo.ThreadSignalDemo`  
    
    





