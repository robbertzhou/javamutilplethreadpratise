一、消息系统的创建  
ActorSystem system = ActorSystem.create("hello", ConfigFactory.load("hello.conf"));
//create顶级的actor  
ActorRef a = system.actorOf(Props.create(HelloWorld.class),"helloworld");  
二、消息投递：  
三种不同的策略：  
1、至多投递一次。  
2、至少投递一次。  
3、精准消息投递。  
顺序没有保障。