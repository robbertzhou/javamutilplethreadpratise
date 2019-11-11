package gaobingfa.ch10;

public class SystemClassLoaderTest {
    public static void main(String[] args){
        System.out.println("boot classloader:"+String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("normal classloader:" + SystemClassLoaderTest.class.getClassLoader());
    }
}
