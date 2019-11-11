package gaobingfa.ch04;

public class VolitleTest {
    static volatile int counter = 0;
    public static void main(String[] args) throws Exception{
        Thread th1 = new Thread(){
            @Override
            public void run() {
                for (int i =0;i<10000;i++){
                    count();
                }
            }
        };
        Thread th2 = new Thread(){
            @Override
            public void run() {
                for (int i =0;i<10000;i++){
                    count();
                }
            }
        };
        th1.start();
        th2.start();
        Thread.sleep(3000);
        System.out.println(counter);
    }

    public static synchronized void count(){
        counter++;
    }
}
