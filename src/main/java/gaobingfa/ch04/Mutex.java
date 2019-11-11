package gaobingfa.ch04;

import java.util.concurrent.TimeUnit;

public class Mutex {
    public final static Object MUTEX = new Object();

    public void accessResource(){
        synchronized (MUTEX){
            try{
                TimeUnit.SECONDS.sleep(100);
            }catch (InterruptedException ex){

            }
        }
    }

    public static void main(String[] args){
        Mutex mutex  = new Mutex();
        for (int i =0;i<5;i++){
            new Thread(mutex::accessResource).start();
        }
    }
}
