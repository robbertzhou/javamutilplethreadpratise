package highconcurrence.chapter02;

/**
 * @create 2020-02-22
 * @author zhouyu
 * @desc 线程组（ThreadGroup）练习
 */
public class ThreadGroupTest {
    public static void main(String[] args){
        Thread t1 = new Thread(()-> System.out.println(Thread.currentThread().getThreadGroup().getName()));
        t1.start();
        ThreadGroup tg = new ThreadGroup("group");
        Thread t2 = new Thread(tg,()-> System.out.println(Thread.currentThread().getThreadGroup().getName()));
        t2.start();
    }
}
