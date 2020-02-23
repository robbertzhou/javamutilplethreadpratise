package highconcurrence.chapter04;

/**
 * create 2020-02-23
 * author zhouyu
 * desc 数据不一致问题代码
 */
public class TicketWindowRunnable implements Runnable{
    public static void main(String[] args){
        Thread t1 = new Thread(new TicketWindowRunnable(),"一号窗口");
        Thread t2 = new Thread(new TicketWindowRunnable(),"二号窗口");
        Thread t3 = new Thread(new TicketWindowRunnable(),"三号窗口");
        Thread t4 = new Thread(new TicketWindowRunnable(),"四号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    private final static Object MUTEX = new Object();
    private int index = 1;
    private final static int MAX = 500;

    @Override
    public void run() {
        while(index <= MAX){
            synchronized (MUTEX){
                System.out.println(Thread.currentThread() + "的号码是:" + (index++));
            }

        }
    }
}
