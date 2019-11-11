package gaobingfa.ch01;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args){
       new Thread(TryConcurrency::enjoyNusic).start();
       new Thread(TryConcurrency::browserNews).start();
    }

    public static void browserNews(){
        for (;;){
            System.out.println("good news");
            sleep(1);
        }
    }

    public static void enjoyNusic(){
        for (;;){
            System.out.println("enjoy music.");
            sleep(1);
        }
    }

    public static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException ex){

        }
    }
}
