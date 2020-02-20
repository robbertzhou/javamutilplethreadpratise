package highconcurrence.chapter01;

/**
 * create 2020-02-20
 * author zhouyu
 * desc 模拟营业厅办理业务
 */
public class TicketWindow extends Thread{

    public static void main(String[] args){
        TicketWindow t1 = new TicketWindow("一号柜台");
        t1.start();
        TicketWindow t2 = new TicketWindow("二号柜台");
        t2.start();

        TicketWindow t3 = new TicketWindow("三号柜台");
        t3.start();
        TicketWindow t4 = new TicketWindow("四号柜台");
        t4.start();
    }

    //柜台名称
    private final String name;
    //最多受理业务数量
    private static final int MAX = 500000;

    private static int index = 1;
    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run(){
        while (index <= MAX){
            System.out.println("柜台：" + name + " 当前号码是：" + (index++));
        }
    }
}
