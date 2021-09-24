package com.asood.cache.ttl;

import com.asood.cache.Cache;
import com.asood.cache.ttl.TimedEvictor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TTLcache<K, V> implements Cache<K, V> {

    private long time = 60;
    private Map<K, V> myCache = new HashMap<>();
    private Map<K, Long> evictionCache = new HashMap<>();
    private ReadWriteLock readWriteLock;
    private Lock readLock;
    private Lock writeLock;

    public TTLcache(long ttl) {
        time = ttl;
        readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
        TimedEvictor tEvic = new TimedEvictor(myCache, evictionCache, ttl, writeLock);
    }

    @java.lang.Override
    public V getEntity(K key) {
        try {
            readLock.lock();
            return myCache.get(key);
        } finally {
            readLock.unlock();
        }

    }

    @java.lang.Override
    public void setEntity(K key, V value) {
        try {
            writeLock.lock();
            myCache.put(key, value);
            long currTime = System.currentTimeMillis() / 1000;
            evictionCache.put(key, currTime);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public V evictEntity(K key) {
        try {
            writeLock.lock();
            evictionCache.remove(key);
            return myCache.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

}
