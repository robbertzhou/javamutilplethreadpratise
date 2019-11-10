package sevensingledesignpattern.writereadseperation;

public interface ReadWriteLock {
    Lock readLock();
    Lock writeLock();

    int getWritingWriters();
    int getWaitingWriters();

    int getReadingReaders();

    static ReadWriteLock getInstance(){
        return new ReadWriteLockImpl();
    }
}
