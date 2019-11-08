package sevensingledesignpattern.monitortask;

import java.util.concurrent.TimeUnit;

public class MonitorTest {
    public static void main(String[] args){
        Observable observable = new ObservableThread<String>(()->{
            try{
                TimeUnit.SECONDS.sleep(3);

            }catch (Exception ex){

            }
            System.out.println("finish done.");
            return "hello";
        });
        observable.start();
    }
}
