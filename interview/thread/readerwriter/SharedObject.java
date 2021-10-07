package interview.thread.readerwriter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedObject {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private Map<Integer, String> syncMap = new HashMap<>();

    public void put(int key, String value) {
        String name = Thread.currentThread().getName();
        writeLock.lock();
        try {
            syncMap.put(key, value);
            System.out.println(name + " added key " + key + " and value " + value);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(int key) {
        String name = Thread.currentThread().getName();
        writeLock.lock();
        try {
            if (syncMap.containsKey(key)) {
                String val = syncMap.remove(key);
                System.out.println(name + " removed value " + val);
                return;
            }
            System.out.println(name + " couldn't remove any value. Map is empty !!!");
        } finally {
            writeLock.unlock();
        }
    }

    public void get(int key) {
        String name = Thread.currentThread().getName();
        readLock.lock();
        try {
            if (syncMap.containsKey(key)) {
                String val = syncMap.get(key);
                System.out.println(name + " retrieved value " + val);
                return;
            }
            System.out.println(name + " couldn't retrieve any value. Map is empty !!! ");
        } finally {
            readLock.unlock();
        }
    }

    public boolean containsKey(int key) {
        readLock.lock();
        try {
            return syncMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }
}
