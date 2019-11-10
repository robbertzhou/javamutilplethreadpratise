package sevensingledesignpattern.writereadseperation;

public interface Lock {
    //显式获取锁，当前线程获取有可能阻塞
    void lock() throws InterruptedException;
    void unlock();
}
