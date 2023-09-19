package com.cache;

import com.cache.dto.CacheServ;
import com.cache.service.CacheImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger("logger");

    public static void main(String[] args) {
        logger.info("Старт програми Cache! " + new Timestamp(System.currentTimeMillis()));

        CacheServ cacheServ = new CacheImpl();
        String cache1 = "nameCache1";
        String key = "keyCache1";
        Object o = "Object1_nameCache1";
        cacheServ.isCacheExist(cache1);
        cacheServ.put(cache1, key, o);

        String cache2 = "nameCache2";
        key = "keyCache2";
        o = "Object1_nameCache2";
        cacheServ.isCacheExist(cache2);
        cacheServ.put(cache2, key, o);

        String cache3 = "nameCache3";
        String keyCache1 = "keyCache1";
        o = "Object1_nameCache3";
        cacheServ.isCacheExist(cache3);
        cacheServ.put(cache3, keyCache1, o);

        String keyCache2 = "keyCache2";
        o = "Object1_nameCache4";
        cacheServ.isCacheExist(cache3);
        cacheServ.put(cache3, keyCache2, o);

//Для перевірки видалення конкретного кеша {
//        cacheServ.clear(cache3);
// }
        System.out.println("Вивели у консоль значення " + cacheServ.get(cache3, keyCache1) + " із кешу: " + cache2 + " під ключем: " + key);

//Для перевірки, що немає ключа {
//        System.out.println(cacheServ.get(cache2, keyCache1).toString()); //null в cache2 немає keyCache1="keyCache1"
// }


//Для перевірки, що всі кеші чисті {
//        cacheServ.clear();
// }

        System.out.println("Вивели у консоль значення " + cacheServ.get(cache2, key) + " із кешу: " + cache2 + " під ключем: " + key);
        logger.info("Кінець програми! " + new Timestamp(System.currentTimeMillis()));
    }
}