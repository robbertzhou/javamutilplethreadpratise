package sevensingledesignpattern.monitortask;

public class EmptyLifecycle<T> implements TaskLifecycle<T> {
    @Override
    public void onStart(Thread thread) {
        System.out.println("空的开始");
    }

    @Override
    public void onRunning(Thread thread) {
        System.out.println("空的运行...");
    }

    @Override
    public void onFinish(Thread thread, T result) {
        System.out.println("空的任务完成了。");
    }

    @Override
    public void onError(Thread thread, Throwable e) {

    }
}
