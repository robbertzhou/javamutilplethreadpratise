package gaobingfa.ch02;

public class ThreadConstruction {
    public static void main(String[] args){
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("group2");
        Thread t2 = new Thread(group,"t2");
        ThreadGroup parentGroup = Thread.currentThread().getThreadGroup();
        System.out.println("main group is " + parentGroup.getName());
        System.out.println("t1 group is " + t1.getThreadGroup().getName());

        System.out.println("t2 group is " + t2.getThreadGroup().getName());
    }
}
