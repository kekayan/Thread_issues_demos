package hiddenDeadLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Task {
    // Object used for FLAT lock
    private final Object sharedObject = new Object();
    // ReentrantReadWriteLock used for WRITE & READ locks
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Execution pattern #1
     */
    public void executeTask1() {

        // 1. Attempt to acquire a ReentrantReadWriteLock READ lock
        lock.readLock().lock();

        // Wait 2 seconds to simulate some work...
        try {
            Thread.sleep(2000);
        } catch (Throwable any) {
        }

        try {
            // 2. Attempt to acquire a Flat lock...
            synchronized (sharedObject) {
            }
        }
        // Remove the READ lock
        finally {
            lock.readLock().unlock();
        }

        System.out.println("executeTask1() :: Work Done!");
    }

    /**
     * Execution pattern #2
     */
    public void executeTask2() {

        // 1. Attempt to acquire a Flat lock
        synchronized (sharedObject) {

            // Wait 2 seconds to simulate some work...
            try {
                Thread.sleep(2000);
            } catch (Throwable any) {
            }

            // 2. Attempt to acquire a WRITE lock
            lock.writeLock().lock();

            try {
                // Do nothing
            }

            // Remove the WRITE lock
            finally {
                lock.writeLock().unlock();
            }
        }

        System.out.println("executeTask2() :: Work Done!");
    }

    public ReentrantReadWriteLock getReentrantReadWriteLock() {
        return lock;
    }
}
