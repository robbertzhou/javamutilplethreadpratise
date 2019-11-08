package sevensingledesignpattern.monitortask;

/**
 * 观察者接口，给调用者使用
 */
public interface Observable {
    enum Cycle{
        STARTED,RUNNING,DONE,ERROR
    }
    //获取线程的生命周期
    Cycle getCycle();
    //定义线程启动方法
    void start();
    //定义打断线程方法
    void interrupt();
}
