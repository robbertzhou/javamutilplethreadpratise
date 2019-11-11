package gaobingfa.ch08;

public interface RunnableQueue {
    void offer(Runnable task);
    Runnable take();
    int size();
}
