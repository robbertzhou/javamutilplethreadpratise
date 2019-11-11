package gaobingfa.ch07;

import static java.lang.System.out;

public class EmptyThreadExceptionUncaught {
    public static void main(String[] args){
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        out.println(threadGroup.getName());
        out.println(threadGroup.getParent().getName());
        new Thread(()->{
            out.println(1/0);
        },"test-thread").start();
    }
}
