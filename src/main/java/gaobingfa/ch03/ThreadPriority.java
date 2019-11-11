package gaobingfa.ch03;

public class ThreadPriority {
    static int t1Counter = 0;
    static int t2Counter = 0;
    public static void main(String[] args){
        setPriorityGroup();
    }

    public static void setPriorityGroup(){
        ThreadGroup group = new ThreadGroup("test");
        group.setMaxPriority(6);
        Thread th = new Thread(group,"group-test");

        th.setPriority(9);
        System.out.println(th.getPriority());
    }

    public static void setPriorityPerformance(){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("t1==" + (t1Counter++));
//                    try {
////                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        t1.setPriority(3);
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("t2==" + (t2Counter ++));
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
