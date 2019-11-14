package practisehighconcurrent.jdkconcurrentpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SafefulHashMapDemo {
    public static void main(String[] args) throws Exception{
        //包装了一个hashmap，用synchronized方式控制这个hashmap，从而达到线程安全
        final Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap  mm = new ConcurrentHashMap();
        final Map<String,String> testMap = new HashMap<>(); //并发下可能出现问题。
        for (int i=0;i<100000;i++){
            Thread th = new Thread(){
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(),"");
                }
            };
            th.start();
        }
        Thread.sleep(3000);
        System.out.println(map.size());
    }
}
