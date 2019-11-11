package gaobingfa.ch04;

import java.util.concurrent.TimeUnit;

public class ClassMonitor {
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try{
            TimeUnit.SECONDS.sleep(10000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static synchronized void method2(){

            System.out.println(Thread.currentThread().getName() + " enter to method2");
            try{
                TimeUnit.SECONDS.sleep(10000);
            }catch (Exception ex){
                ex.printStackTrace();
            }


    }

    public static void main(String[] args){

        new Thread(ClassMonitor::method1,"T1").start();
        new Thread(ClassMonitor::method2,"T2").start();
    }
}
