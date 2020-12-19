package com.zy.redispractice;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

public class FirstRedis {
    private JedisPool pool;
    public static void main(String[] args) {
        FirstRedis fr = new FirstRedis();
        fr.init();
//        fr.addString("mykey","中国人民好");
//        System.out.println(fr.getValue("mykey"));
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(300);
//        userEntity.setName("jack");
//        byte[] bis = fr.toByteArray(userEntity);
//        fr.addBytes("jj",bis);
//        byte[] bytes = fr.getBytes("jj".getBytes());
//        UserEntity uu = (UserEntity) fr.toObject(bytes);
//        System.out.println(uu.getName());

        fr.addList("mylist","one","two","three");
//        System.out.println(fr.getList("mylist"));
//        System.out.println(fr.getList("mylist"));
//        System.out.println(fr.getList("mylist"));
    }

    public void init(){
        JedisPoolConfig conf = new JedisPoolConfig();
        conf.setMaxTotal(10);

        pool = new JedisPool(conf,"other",6379);
    }
    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     * @param bytes
     * @return
     */
    public Object toObject (byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    public void addBytes(String key,byte[] obj){
        Jedis jedis = pool.getResource();
        jedis.set(key.getBytes(),obj);
    }

    public void addString(String key,String value){
        Jedis jedis = pool.getResource();

        jedis.set(key,value);
    }
    public String getValue(String key){
        Jedis jedis = pool.getResource();
        return jedis.get(key);
    }

    public byte[] getBytes(byte[] key){
        Jedis jedis = pool.getResource();
        return jedis.get(key);
    }

    public void addList(String key,String ... values){
        Jedis jedis = pool.getResource();
        jedis.lpush(key,values);
    }

    public String getList(String key){
        Jedis jedis = pool.getResource();
        return jedis.lpop(key);
    }



}
