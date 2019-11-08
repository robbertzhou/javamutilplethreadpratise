package sevensingledesignpattern;

/**
 * 饿汉式
 * final不允许被继承
 * cinit是同步方法，能保证只能实例化一次。
 */
public final class SingletonEHan {
    private byte[] data = new byte[1024];
    private static SingletonEHan singleton = new SingletonEHan();

    private SingletonEHan(){}

    public static SingletonEHan getInstance(){
        return singleton;
    }
}
