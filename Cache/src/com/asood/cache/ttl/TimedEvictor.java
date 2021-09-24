package com.asood.cache;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TimedEvictor<K, V> {
    Map<K, V> dataCache;
    Map<K, Long> evictionCache;
    long ttl = 0;
    Lock writeLock;

    TimedEvictor(Map<K, V> dataCache, Map<K, Long> evictionCache, long ttl, Lock writeLock) {
        this.dataCache = dataCache;
        this.evictionCache = evictionCache;
        this.ttl = ttl;
        this.writeLock = writeLock;
    }

    void scheduleTimedEviction() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Evictor evictor = new Evictor();
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(evictor, 1000, ttl / 2, TimeUnit.MILLISECONDS);
    }

    private class Evictor implements Runnable {
        @Override
        public void run() {
            try {
                writeLock.lock();
                Long currTime = System.currentTimeMillis();
                for (Map.Entry<K, Long> entry : evictionCache.entrySet()) {
                    if (entry.getValue() + ttl >= currTime) {
                        evictionCache.remove(entry.getKey());
                        dataCache.remove(entry.getKey());
                    }
                }
            } finally {
                writeLock.unlock();
            }
        }
    }
}


