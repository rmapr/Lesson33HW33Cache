package com.cache.dto;

public interface CacheServ {
boolean put(String cache, String key, Object o);
Object get (String cache, String key);
void clear();
void clear(String cache);
void isCacheExist(String cache);

}
