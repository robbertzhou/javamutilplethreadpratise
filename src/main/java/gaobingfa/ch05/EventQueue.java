package gaobingfa.ch05;

import java.util.LinkedList;

public class EventQueue {
    static class Event{}

    private int max = 0;
    private final int DEFAULT_MAX = 3000000;

    public EventQueue(){
        this.max = DEFAULT_MAX;
    }

    public EventQueue(int max){
        this.max = max;
    }

    private LinkedList<Event> list = new LinkedList<>();

    public void offer(){
        synchronized (list){
            try{
                if(list.size() >= max){
                    System.out.println(Thread.currentThread().getName() + " is ful.");
                    list.wait();
                }
                list.add(new Event());
                list.notify();
                System.out.println(Thread.currentThread().getName() + " is offered.");
            }catch (InterruptedException ex){

            }
        }
    }

    public void take(){
        synchronized (list){
            try{
                if (list.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + " is empty.");
                    list.wait();
                }
                list.removeFirst();
                list.notify();
                System.out.println(Thread.currentThread().getName() + " is taked.");
            }catch (InterruptedException ex){

            }
        }
    }

    public static void main(String[] args){
        EventQueue queue1 = new EventQueue();

        new Thread(()->{
            while (true){
                queue1.offer();
            }
        }).start();
        new Thread(()->{
            while(true){
                queue1.take();
            }
        }).start();
    }
}
