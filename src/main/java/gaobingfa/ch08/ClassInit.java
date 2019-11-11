package gaobingfa.ch08;

public class ClassInit {
    static {
        System.out.println("Class init.");
    }

    public static int i = 20;

    public static void main(String[] args){
        for (int i =0;i<5;i++){
            new Thread(()->{
                System.out.println(ClassInit.i);
            }).start();
        }
    }
}
