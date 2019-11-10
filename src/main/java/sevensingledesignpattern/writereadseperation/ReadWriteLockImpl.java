package sevensingledesignpattern.writereadseperation;

public class ReadWriteLockImpl implements ReadWriteLock {
    private final Object MUTEX = new Object();
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private int readingReaders = 0;
    private boolean preferWriter;

    public ReadWriteLockImpl(){
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter){
        this.preferWriter = preferWriter;
    }

    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitingWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    public Object getMUTEX(){
        return MUTEX;
    }

    public void incrementWritingWriters(){
        this.writingWriters++;
    }

    public void decrementWritingWriters(){
        this.writingWriters--;
    }

    public void incrementWaitingWriters(){
        this.waitingWriters++;
    }

    public void decrementWaitingWriters(){
        this.waitingWriters--;
    }

    public void incrementReadingReader(){
        this.readingReaders++;
    }

    public void decrementReadingReader(){
        this.readingReaders--;
    }

    public boolean getPreferWriter(){
        return this.preferWriter;
    }

    public void changePreferWriting(boolean preferWriter){
        this.preferWriter = preferWriter;
    }

}
