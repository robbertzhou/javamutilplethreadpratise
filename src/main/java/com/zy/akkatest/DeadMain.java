package com.zy.akkatest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class DeadMain {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("deadwatch", ConfigFactory.load("hello.conf"));
        ActorRef worker = system.actorOf(Props.create(MyWorker.class),"worker");
        system.actorOf(Props.create(WatchActor.class,worker),"watcher");
        worker.tell(MyWorker.WorkMsg.WORKING,ActorRef.noSender());
        worker.tell(MyWorker.WorkMsg.DONE,ActorRef.noSender());
        worker.tell(PoisonPill.getInstance(),ActorRef.noSender());
    }
}
