package gaobingfa.ch08;

@FunctionalInterface
public interface DenyPolicy {
    void reject(Runnable task, ThreadPool pool);
}
