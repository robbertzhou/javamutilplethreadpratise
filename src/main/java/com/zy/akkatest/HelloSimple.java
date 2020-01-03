package com.zy.akkatest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class HelloSimple {
    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("hello", ConfigFactory.load("hello.conf"));
        ActorRef a = system.actorOf(Props.create(HelloWorld.class),"helloworld");
        System.out.println(a.path());
        System.exit(-1);
    }
}
