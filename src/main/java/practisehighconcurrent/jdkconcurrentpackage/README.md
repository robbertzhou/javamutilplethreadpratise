一、synchronized锁是不公平的。  
ReentrantLock可以实现公平锁，但由于要维护一个锁队列，性能比较低下。  
new ReentrantLock(true);//默认是false，非公平锁。  

二、Conditiion  
让线程可以在合适的时间等待，并在特定时间获取通知，继续执行。  （94页）
