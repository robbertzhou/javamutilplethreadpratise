package gaobingfa.ch08;

public class DiscardDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable task, ThreadPool pool) {

    }
}
