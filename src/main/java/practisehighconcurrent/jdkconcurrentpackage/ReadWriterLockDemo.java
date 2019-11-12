package practisehighconcurrent.jdkconcurrentpackage;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁分离
 */
public class ReadWriterLockDemo {
    private static ReentrantLock lock = new ReentrantLock();
    final  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

   private int value;

   public Object handleRead(Lock ll){
       try{
           ll.lock();
           TimeUnit.SECONDS.sleep(1);
           System.out.println("read date:" + sdf.format(new Date()));
           return value;
       }catch (Exception ex){
           return value;
       }
       finally {
           ll.unlock();
       }
   }

   public void handleWrite(Lock ll,int vv){
       try{
           ll.lock();
           TimeUnit.SECONDS.sleep(1);
           System.out.println("write date:" + sdf.format(new Date()));
       }catch(InterruptedException ex){
           ex.printStackTrace();
       }
           finally {
           ll.unlock();
       }
   }

   public static void main(String[] args){

       System.out.println("start " + sdf.format(new Date()));
       final ReadWriterLockDemo demo = new ReadWriterLockDemo();
       Runnable readRunnable = new Runnable() {
           @Override
           public void run() {
//               demo.handleRead(readLock);
               demo.handleRead(lock);
           }
       };

       Runnable writeRunnable = new Runnable() {
           @Override
           public void run() {
//                demo.handleWrite(writeLock,new Random().nextInt(100));
               demo.handleWrite(lock,new Random().nextInt(100));
           }
       };
       for (int i=0;i<18;i++){
           new Thread(readRunnable).start();
       }

       for (int i=0;i<20;i++){
           new Thread(writeRunnable).start();
       }
   }
}
