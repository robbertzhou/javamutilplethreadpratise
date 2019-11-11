package gaobingfa.ch02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadNamed {
    public static void main(String[] args){
        Stream<Thread> ths = IntStream.range(0,5).boxed().map(i-> new Thread("th" + i){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        ths.forEach(Thread::start);
    }
}
