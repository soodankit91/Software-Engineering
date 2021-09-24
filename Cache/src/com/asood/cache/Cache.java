package com.asood.cache;

public interface Cache<K, V> {

    public V getEntity(K key);

    public void setEntity(K key, V value);

    public V evictEntity(K key);
}
