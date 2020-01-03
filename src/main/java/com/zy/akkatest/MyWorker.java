package com.zy.akkatest;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.sql.SQLSyntaxErrorException;

public class MyWorker extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);
    public static enum WorkMsg{
        WORKING,
        DONE,
        CLOSE
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("Myworker is starting.");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("Myworker is stopping.");
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message == WorkMsg.WORKING){
            System.out.println("I am working.");
        }
        if(message == WorkMsg.DONE){
            System.out.println("Stop working.");
        }

        if(message == WorkMsg.CLOSE){
            System.out.println("I will shutdown.");
            getSender().tell(WorkMsg.CLOSE,getSelf());
            getContext().stop(getSelf());
        }else{
            unhandled(message);
        }
    }
}
