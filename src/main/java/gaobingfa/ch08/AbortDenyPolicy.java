package gaobingfa.ch08;

public class AbortDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable task, ThreadPool pool) {
        throw new RuntimeException("will abort.");
    }
}
