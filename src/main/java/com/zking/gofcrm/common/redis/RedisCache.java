package com.zking.gofcrm.common.redis;

import org.apache.ibatis.cache.Cache;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 说明：该类实现MyBatis的Cache接口
 *       使用Redis来实现MyBatis的缓存策略
 *
 * @author Jzw
 * @date 2018/2/3 15:38
 */
public class RedisCache implements Cache {

    /**
     * 打印日志对象
     */
    private Logger logger = LoggerFactory.getLogger(RedisCache.class);

    /**
     * Redis的缓存模板，Redis通过它来快速的对数据进行操作
     */
    private static RedisTemplate redisTemplate;

    /**
     * 标识符
     */
    private final String id;

    /**
     * 标识符的前缀
     */
    private final String PRO_STR = "GOFCRM";

    /**
     * 标识符的后缀
     */
    private final String SUF_STR = "REDIS";

    /**
     * Redis的写锁，此锁是线程同步的，独占锁 每次只有一个线程能够操作（写入）数据
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * Redis自带的序列化操作工具
     */
    private JdkSerializationRedisSerializer jdkSerialization = new JdkSerializationRedisSerializer();


    /**
     * 按照一定规则生成唯一标识符
     * @param key
     * @return
     */
    private byte[] getGzId(Object key) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PRO_STR);
        stringBuilder.append("-");
        stringBuilder.append(key);
        stringBuilder.append("-");
        stringBuilder.append(SUF_STR);

        return jdkSerialization.serialize(stringBuilder.toString());
    }

    /**
     * 唯一的构造方法
     * @param id
     */
    public RedisCache(final String id) {
        if (null == id) {
            throw new RuntimeException("进行缓存的主键不能为NULL");
        }
        logger.debug("RedisCache："+id);
        this.id = id;
    }

    /**
     * @return 此缓存的标识符
     */
    public  String getId() {
        return this.id;
    }

    /**
     * 对 数据 进行缓存操作
     * @param key   Can be any object but usually it is a {@link CacheKey}
     * @param value The result of a select.
     */
    public void putObject(Object key, Object value) {
        if (null != value) {
            try{
                /**
                 * 对数据进行缓存
                 * TimeUnit.DAYS 2 表示缓存时效为2天
                 */
                redisTemplate.opsForValue().set(getGzId(key),
                        jdkSerialization.serialize(value),
                        2, TimeUnit.DAYS);
            } catch (Exception e){
              logger.error("数据缓存出现错误", e);
            }
        }
    }

    /**
     * 根据键 获取缓存的数据
     * @param key The key
     * @return The object stored in the cache.
     */
    public Object getObject(Object key) {
        if (null != key) {
            try{
                Object redisObj = redisTemplate.opsForValue().get(getGzId(key));
                return jdkSerialization.deserialize((byte[]) redisObj);
            } catch (Exception e){
              logger.error("获取缓存出现错误", e);
            }
        }
        return null;
    }

    /**
     * 移除当前对象中指定KEY所对应的对象
     * As of 3.3.0 this method is only called during a rollback
     * for any previous value that was missing in the cache.
     * This lets any blocking cache to release the lock that
     * may have previously put on the key.
     * A blocking cache puts a lock when a value is null
     * and releases it when the value is back again.
     * This way other threads will wait for the value to be
     * available instead of hitting the database.
     *
     * @param key The key
     * @return Not used
     */
    public Object removeObject(Object key) {
        if (null != key) {
            try{
                /**
                 * 这里使数据立即失效，达到移除数据的效果
                 */
                redisTemplate.expire(getGzId(key),1, TimeUnit.SECONDS);
            } catch (Exception e){
               logger.error("removeObject移除缓存出现错误！",e);
            }
        }
        return null;
    }

    /**
     * 清楚当前缓存的所有对象
     * Clears this cache instance
     */
    public void clear() {
        Long size = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Long size = redisConnection.dbSize();
                redisConnection.flushDb();//连续删除
                redisConnection.flushAll();
                return size;
            }
        });
        logger.debug("清除了："+size+"对象");
    }

    /**
     * 获取Redis当前的缓存对象数量
     * Optional. This method is not called by the core.
     *
     * @return The number of elements stored in the cache (not its capacity).
     */
    public int getSize() {
        Long size = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.dbSize();
            }
        });
        return size.intValue();
    }

    /**
     * 获取 Readis的写锁
     * Optional. As of 3.2.6 this method is no longer called by the core.
     * <p>
     * Any locking needed by the cache must be provided internally by the cache provider.
     *
     * @return A ReadWriteLock
     */
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }


    /**
     * 从第三者中转移注入 RedisTemplate
     * @param redisTemplate
     */
    public static void setRedisTemplate(RedisTemplate redisTemplate){
        RedisCache.redisTemplate = redisTemplate;
    }


}
