package sevensingledesignpattern.monitortask;

public class ObservableThread<T> extends Thread implements Observable{
    private final TaskLifecycle<T> lifecycle;
    private final Task<T> task;
    private Cycle cycle;

    public ObservableThread(Task<T> task){
        this(new EmptyLifecycle<>(),task);
    }

    public ObservableThread(TaskLifecycle<T> lifecycle,Task<T> task){
        super();
        this.lifecycle = lifecycle;
        this.task = task;
    }

    @Override
    public void run() {
        this.update(Cycle.STARTED,null,null);
        try{
            this.update(Cycle.RUNNING,null,null);
            T result = this.task.call();
            this.update(Cycle.DONE,result,null);
        }catch (Exception ex){
            this.update(Cycle.ERROR,null,ex);
        }
    }

    private void update(Cycle cycle,T result,Exception e){
        this.cycle = cycle;
        if(lifecycle == null){
            return;
        }
        try{
            switch (this.cycle){
                case STARTED:
                    this.lifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(),result);
                case ERROR:
                    this.lifecycle.onError(currentThread(),e);
            }
        }
        catch (Exception ex){

        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
