package gaobingfa.ch08;

public interface ThreadPool {
    void execute(Runnable task);
    void shutdown();
    int getInitSize();
    int getQueuSize();
    int getCoreSize();
    int getMaxSize();
    boolean isShutdown();
}
