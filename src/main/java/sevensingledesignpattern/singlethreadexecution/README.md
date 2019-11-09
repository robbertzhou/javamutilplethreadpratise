一、机场安检  
非线程安全0方式。  
问题分析：  
pass方法调用中，传递时能保证原子性；而在赋值操作中不能保证原子性。  
修改：pass方法加synchronized，表示只有一个线程访问.  
但要尽可能缩小synchronized的作用域。  

二、吃面问题  
public static void main(String[] args){  
        Tableware left = new Tableware("fork");  
        Tableware right = new Tableware("knife");  
        EatNoodleThread t1 = new EatNoodleThread("A",left,right);  
        EatNoodleThread t2 = new EatNoodleThread("B",right,left);  
        t1.start();  
        t2.start();  
    }  
 解决办法，生成一个TablewarePair对象  