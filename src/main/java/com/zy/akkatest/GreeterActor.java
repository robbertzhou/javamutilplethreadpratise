package com.zy.akkatest;

import akka.actor.UntypedActor;

public class GreeterActor extends UntypedActor {
    public static enum Msg{
        Start,
        Greeter,
        DONE
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message==Msg.Greeter){
            System.out.println("welcome,i done work.");
            getSender().tell(Msg.DONE,getSelf());
            getContext().stop(getSelf());
        }else if(message == Msg.Start){
            System.out.println("I start doing work.");
            getSender().tell(Msg.DONE,getSelf());
        }else{
            unhandled(message);
        }
    }
}
