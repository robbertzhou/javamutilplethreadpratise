package sevensingledesignpattern.writereadseperation;

public class ReadLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock){
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()){
            while (readWriteLock.getWaitingWriters() > 0 ||
                    (readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() >0)){
                readWriteLock.getMUTEX().wait();
            }
            readWriteLock.incrementReadingReader();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()){
            readWriteLock.decrementReadingReader();
            readWriteLock.changePreferWriting(true);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
