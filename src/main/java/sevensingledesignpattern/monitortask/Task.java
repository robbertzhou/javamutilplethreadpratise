package sevensingledesignpattern.monitortask;

public interface Task<T> {
    //任务执行接口，接口允许有返回值
    T call();
}
