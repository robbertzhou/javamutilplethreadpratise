package highconcurrence.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * create 2020-02-22
 * author zhouyu
 * desc 线程yield方法
 *  如果没有yield方法，1,2,3，4,5不是按顺序打印
 */
public class ThreadYield {
    public static void main(String[] args){
        IntStream.range(0,5).mapToObj(ThreadYield::createThread).forEach(Thread::start);
    }

    private static Thread createThread(int index){

        return new Thread(
                ()->{
                    try {
                        TimeUnit.MILLISECONDS.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(index);
                }
        );
    }
}
