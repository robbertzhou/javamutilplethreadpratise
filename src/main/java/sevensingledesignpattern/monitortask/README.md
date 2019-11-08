把Thread封装为ObservableThread，继承Observable接口，Observable接口定义了Thread
的启动方法。
Override
void run(){
    this.update(Cycle.STARTED);
    this.udpate(Cycle.RUNNING);
    T result = task.call();
    this.update(Cycle.DONE);
}