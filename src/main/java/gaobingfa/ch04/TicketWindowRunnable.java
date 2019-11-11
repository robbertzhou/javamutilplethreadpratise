package gaobingfa.ch04;

public class TicketWindowRunnable implements Runnable {
    static int MAX = 500;  //共享资源
    private int index = 1;
    final static Object MUTEX = new Object();
    @Override
    public void run() {
        while (index <= MAX){
            synchronized (MUTEX){
                System.out.println("current thread id is " +
                        Thread.currentThread().getId() + ";index=" +(index++));
            }

        }
    }

    public static void main(String[] args){
        TicketWindowRunnable task = new TicketWindowRunnable();
        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        Thread th3 = new Thread(task);
        Thread th4 = new Thread(task);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
