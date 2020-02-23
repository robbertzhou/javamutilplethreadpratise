package highconcurrence.chapter04;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * create 2020-02-23
 * author zhouyu
 * desc 用jconsole、jstack命令分析线程堆栈
 */
public class Mutex {
    private final Object MUTEX = new Object();

    public static void main(String[] args){
        Mutex mutex = new Mutex();
        IntStream.range(1,5).mapToObj(i ->new Thread(mutex::accessResource,"zhouyu" + i)).forEach(Thread::start);
    }

    public void accessResource(){
        synchronized (MUTEX){
            try{
                TimeUnit.SECONDS.sleep(1200);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
