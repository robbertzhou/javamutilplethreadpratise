package sevensingledesignpattern.singlethreadexecution;

import javafx.scene.control.Tab;

public class EatNoodleThread extends Thread {
//    private Tableware leftTool;
//    private  Tableware rightTool;
    private final String name;

    private TablewarePair pair;

//    public EatNoodleThread(String name,Tableware leftTool,Tableware rightTool){
//        this.name = name;
//        this.leftTool = leftTool;
//        this.rightTool = rightTool;
//    }

    public EatNoodleThread(String name,TablewarePair pair){
        this.pair = pair;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            this.eat();
        }
    }

    private void eat(){
        synchronized (pair){
            System.out.println(name + " take up " + pair.getLeftTool() + "(left)");

                System.out.println(name + " take up " + pair.getRightTool() + "(right)");
                System.out.println(name + " is eating.");
                System.out.println(name + " putdown " + pair.getRightTool());

            System.out.println(name + " putdown " + pair.getLeftTool());
        }
    }

    public static void main(String[] args){
        Tableware left = new Tableware("fork");
        Tableware right = new Tableware("knife");
        TablewarePair pair = new TablewarePair(left,right);
//        EatNoodleThread t1 = new EatNoodleThread("A",left,right);
//        EatNoodleThread t2 = new EatNoodleThread("B",right,left);
        EatNoodleThread t1 = new EatNoodleThread("A",pair);
        EatNoodleThread t2 = new EatNoodleThread("B",pair);
        t1.start();
        t2.start();
    }
}
