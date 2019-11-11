package gaobingfa.ch04;

import java.util.HashMap;

public class HashMapDeadLock {
    private final HashMap<String,String> map = new HashMap<>();

    public void add(String key,String value){
        map.put(key,value);
    }

    public static void main(String[] args){
        HashMapDeadLock hdl = new HashMapDeadLock();
        for (int i=0;i<2;i++){
            new Thread(()->{
                for (int j=0;j<Integer.MAX_VALUE;j++){
                    hdl.add(String.valueOf(j),"kkk");
                }
            }).start();
        }
    }
}
