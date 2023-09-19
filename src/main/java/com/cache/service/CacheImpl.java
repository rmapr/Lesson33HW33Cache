package com.cache.service;

import com.cache.dto.CacheServ;
import com.cache.exception.CacheNotFoundException;
import com.cache.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

import static com.cache.Main.logger;

public class CacheImpl implements CacheServ {
    private final Map<String, Map<String, Object>> cacheMain;

    public CacheImpl() {
        this.cacheMain = new HashMap<>();
    }

    @Override
    public boolean put(String cache, String key, Object o) {
        if (!cacheMain.containsKey(cache)) {
            cacheMain.put(cache, new HashMap<>());
            logger.info("Створили новий кеш: " + cache);
        }
        cacheMain.get(cache).put(key, o);
        logger.info("Поклали в кеш: " + cache + "; ключ: " + key + "; значення: " + o);
        return true;
    }

    @Override
    public Object get(String cache, String key) {
        if (!cacheMain.containsKey(cache)) {
            logger.error("Кеш: " + cache + " відсутній!");
            throw new CacheNotFoundException("Cache " + cache + " not found.");
        }
        if (!cacheMain.get(cache).containsKey(key)) {
            logger.error("Ключ: " + key + " відсутній!");
            throw new KeyNotFoundException("Key " + key + " not found.");
        }
        logger.info("Повернули з кешу: " + cache + "; ключа: " + key + "; значення: " + cacheMain.get(cache).get(key));
        return cacheMain.get(cache).get(key);
    }

    @Override
    public void clear() {
        if (!cacheMain.isEmpty()) {cacheMain.clear();
            logger.info("Очістили всі кеши.");
            logger.info("Size map after clear all: " + cacheMain.size());
        }
    }

    @Override
    public void clear(String cache) {
        isCacheExist(cache);
        cacheMain.remove(cache);
        logger.info("Очістили кеш " + cache);
        isCacheExist(cache);
    }

    @Override
    public void isCacheExist(String cache) {
        if (!cacheMain.containsKey(cache)) {
            logger.info("Кеш: " + cache + " відсутній!");
        } else logger.info("Кеш: " + cache + " присутній!");
    }
}
