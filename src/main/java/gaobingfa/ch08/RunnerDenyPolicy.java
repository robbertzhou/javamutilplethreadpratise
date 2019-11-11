package gaobingfa.ch08;

public class RunnerDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable task, ThreadPool pool) {
        if(!pool.isShutdown()){
            task.run();
        }
    }
}
