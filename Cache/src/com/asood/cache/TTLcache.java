package com.asood.cache;

import java.util.HashMap;
import java.util.Map;

public class TTLcache<K,V> implements Cache<K,V>{

    private long time = 60;
    private Map<K,V> myCache = new HashMap<>();
    private Map<K,Long> evictionCache = new HashMap<>();

    public TTLcache(long ttl) {
        time = ttl;
        TimedEvictor tEvic = new TimedEvictor(myCache, evictionCache);
    }

    @java.lang.Override
    public V getEntity(K key) {
        return myCache.get(key);
    }

    @java.lang.Override
    public void setEntity(K key, V value) {
        myCache.put(key, value);
        long currTime = System.currentTimeMillis() / 1000;
        evictionCache.put(key, currTime);
    }

    @Override
    public V evictEntity(K key) {
        evictionCache.remove(key);
        return myCache.remove(key);
    }

}
