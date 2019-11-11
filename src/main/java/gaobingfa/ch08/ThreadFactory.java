package gaobingfa.ch08;

@FunctionalInterface
public interface ThreadFactory {
    Thread create(Runnable task);
}
