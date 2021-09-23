package com.asood.cache;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TimedEviction<K,V> {
    Map<K,V> dataCache ;
    Map<K,Long> evictionCache;

    TimedEviction(Map<K,V> dataCache, Map<K,Long> evictionCache) {
        this.dataCache = dataCache;
        this.evictionCache = evictionCache;
    }

    void scheduleTimedEviction() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    }
}
