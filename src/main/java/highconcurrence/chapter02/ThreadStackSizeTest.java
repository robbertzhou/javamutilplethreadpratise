package highconcurrence.chapter02;



/**
 * create 2020-02-22
 * author:zhouyu
 * desc:线程堆栈测试 statckoverflow
 */
public class ThreadStackSizeTest {
    public static void main(String[] args){
        ThreadGroup testGroup = new ThreadGroup("testGroup");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                recurse(1);
            }
            private void recurse(int i){
                System.out.println(i);
                if(i< Long.MAX_VALUE){
                    recurse(i+1);
                }
            }
        };
        Thread t = new Thread(testGroup,runnable,"Test",1);
        t.start();
    }
}
