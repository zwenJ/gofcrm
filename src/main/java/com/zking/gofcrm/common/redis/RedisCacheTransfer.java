package com.zking.gofcrm.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 说明：将Spring中生产的RedisTemplate转移到RedisCache中
 *
 * @author Jzw
 * @date 2018/2/3 15:44
 */
@Component
public class RedisCacheTransfer {

    @Autowired
    public void setTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }

}
