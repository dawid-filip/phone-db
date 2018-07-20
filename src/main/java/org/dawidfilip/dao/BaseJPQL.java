package org.dawidfilip.dao;

public interface BaseJPQL<T, K> extends BaseDML<T>, BaseSELECT<T, K>, EntityManager {
}
