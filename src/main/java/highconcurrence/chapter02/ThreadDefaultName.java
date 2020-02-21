package highconcurrence.chapter02;

import java.util.stream.IntStream;

/**
 * create 2020-02-20
 * author zhouyu
 * desc 测试threa默认构造函数
 */
public class ThreadDefaultName {
    public static void main(String[] args) throws Exception{
        IntStream.range(0,5).boxed().map(i ->
            new Thread(
                    () -> System.out.println(Thread.currentThread().getName())
            )
        ).forEach(Thread::start);
    }
}
