package org.ouyushan.springboot.data.cache.check;

/**
 * @Description: 获取缓存实现方式
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/8 15:24
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerCheck implements CommandLineRunner {

    private static final Log logger = LogFactory.getLog(CacheManagerCheck.class);

    private final CacheManager cacheManager;

    public CacheManagerCheck(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("\n\n" + "=========================================================\n" + "Using cache manager: "
                + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }

}
