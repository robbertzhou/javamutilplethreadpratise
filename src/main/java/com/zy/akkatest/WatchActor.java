package com.zy.akkatest;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WatchActor extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    public WatchActor(ActorRef ref){
        getContext().watch(ref);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof Terminated){
            getContext().getSystem().terminate();
        }else{
            unhandled(message);
        }
    }
}
