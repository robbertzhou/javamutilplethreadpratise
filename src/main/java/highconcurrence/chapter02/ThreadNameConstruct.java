package highconcurrence.chapter02;

import java.util.stream.IntStream;

/**
 * create 2020-02 -21
 * author zhouyu
 * desc 构造线程用名字
 */
public class ThreadNameConstruct {
    public static void main(String[] args){
        IntStream.range(0,5).mapToObj(ThreadNameConstruct::createThread).forEach(Thread::start);
    }

    private static Thread createThread(final int intName){
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName() )
                ,"ALEX-" + intName
        );
    }
}
