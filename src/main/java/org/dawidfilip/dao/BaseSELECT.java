package org.dawidfilip.dao;

import java.util.List;

public interface BaseSELECT<T, K> {
	public T find(K key);
	public List<T> findAll();
}
