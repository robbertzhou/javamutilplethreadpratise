package practisehighconcurrent.jdkconcurrentpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParseData implements Runnable {
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final int i;
    public ParseData(int i){
        this.i = i;
    }
    @Override
    public void run() {
        String val = "2019-12-11 22:11:" + i %60;
        try {

                Date  dd = sdf.parse(val);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(300);
        for (int i=0;i<5;i++){
            ParseData pd = new ParseData(i);
            new Thread(pd).start();
        }
    }

}
