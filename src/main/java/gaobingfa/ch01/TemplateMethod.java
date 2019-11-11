package gaobingfa.ch01;

/**
 * 模板设计模式方法例子
 */
public class TemplateMethod {
    public final void  print(String message){
        System.out.println("#############");
        wrapPrint(message);
        System.out.println("#############");
    }

    protected void wrapPrint(String message){
        System.out.println(message);
    }

    public static void main(String[] args){
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        t1.print("hello world");
        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("?" + message + "?");
            }
        };
        t2.print("hello world");
    }
}
