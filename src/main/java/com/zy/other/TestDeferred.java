package com.zy.other;


import static java.lang.System.err;
import static java.lang.System.out;
import com.stumbleupon.async.Deferred;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * create 2020-08-22
 * author zy
 * desc
 */
public class TestDeferred {
    public static void main(String[] args) throws Exception{
        out.println(Thread.currentThread().getName());
        Deferred<String> deferred = new Deferred<String>().addBoth(str ->{
            out.println(Thread.currentThread().getName());
            return str;
        }).addBothDeferring(obj->{
          Deferred<String> d = new Deferred<>();
          d.addBoth(str ->{
              out.println(Thread.currentThread().getName());
              return str;
          });
          Executors.newSingleThreadExecutor().execute(()->{
              d.callback("jack");
          });
          return d;
        }).addBoth(s->{
            out.println(Thread.currentThread().getName());
            return s;
        }).addErrback(error->{
            return err;
        });
        Executors.newSingleThreadExecutor().execute(()->{
            deferred.callback("hello");
        });
        
    }
}
