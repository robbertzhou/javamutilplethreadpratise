package sevensingledesignpattern.monitortask;

/**
 * 任务生命周期接口
 */
public interface TaskLifecycle<T> {
    //任务启动时触发
    void onStart(Thread thread);
    //任务运行时触发
    void onRunning(Thread thread);
    //线程执行完毕后触发，result是执行结果
    void onFinish(Thread thread,T result);
    //任务报错是触发
    void onError(Thread thread,Throwable e);
}
