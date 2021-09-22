package com.asood.cache;

public interface Cache<K,V> {
	
	public void getEntity();
	public void setEntity(K key, V value);
	public void evictEntity(K key);
}
