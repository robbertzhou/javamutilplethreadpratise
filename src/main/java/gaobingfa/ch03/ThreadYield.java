package gaobingfa.ch03;

import java.util.stream.IntStream;

public class ThreadYield {
    public static void main(String[] args){
        IntStream.range(0,4).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    public static Thread create(int index){
        return new Thread(){
            @Override
            public void run() {
                if (index == 0)
                Thread.yield();
                System.out.println(index);
            }
        };
    }
}
