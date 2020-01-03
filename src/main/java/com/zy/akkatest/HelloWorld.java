package com.zy.akkatest;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class HelloWorld extends UntypedAbstractActor {
    ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(GreeterActor.class),"greeter");
        System.out.println(greeter.path());
        greeter.tell(GreeterActor.Msg.Start,getSelf());
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message == GreeterActor.Msg.DONE){
            greeter.tell(GreeterActor.Msg.Greeter,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }
}
