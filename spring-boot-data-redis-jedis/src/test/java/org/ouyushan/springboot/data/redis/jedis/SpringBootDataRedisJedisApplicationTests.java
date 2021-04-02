package org.ouyushan.springboot.data.redis.jedis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.redis.jedis.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDataRedisJedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringRedisTemplateForObject() {
        stringRedisTemplate.opsForValue().set("keyString", "valueString");
        String value = stringRedisTemplate.opsForValue().get("keyString");
        System.out.println(value);
        assertThat(value).isEqualTo("valueString");
    }

    @Test
    public void testRedisTemplateForObject() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(24);
        userInfo.setId(1L);
        userInfo.setUserName("username");
        userInfo.setPassword("password");

        redisTemplate.opsForValue().set("object", userInfo);
        UserInfo userInfoFromRedis = (UserInfo) redisTemplate.opsForValue().get("object");
        System.out.println(userInfoFromRedis);
    }

    @Test
    public void testRedisTemplateForList() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setAge(11);
        userInfo1.setId(1L);
        userInfo1.setUserName("username");
        userInfo1.setPassword("password");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setAge(21);
        userInfo2.setId(2L);
        userInfo2.setUserName("username");
        userInfo2.setPassword("password");

        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo1);
        list.add(userInfo2);

        redisTemplate.opsForValue().set("list", list);
        List<UserInfo> userInfoFromRedis = (List) redisTemplate.opsForValue().get("list");
        System.out.println(userInfoFromRedis);
    }

    @Test
    public void testRedisTemplateForMap() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setAge(11);
        userInfo1.setId(1L);
        userInfo1.setUserName("username");
        userInfo1.setPassword("password");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setAge(22);
        userInfo2.setId(2L);
        userInfo2.setUserName("username");
        userInfo2.setPassword("password");

        Map<String, UserInfo> map = new HashMap<>();
        map.put("userInfo1", userInfo1);
        map.put("userInfo2", userInfo2);

        redisTemplate.opsForValue().set("map", map);
        Map<String, UserInfo> userInfoFromRedis = (Map<String, UserInfo>) redisTemplate.opsForValue().get("map");
        System.out.println(userInfoFromRedis);
    }

    /**
     * 缓存雪崩
     * 解决方案
     * 1、使用锁或者队列，实现单线程缓存写入，从而避免在发生故障时大量并发请求落在底层存储系统上。
     * 2、向缓存的过期时间添加一个随机值，比如1-5分钟。
     */
    @Test
    public void testRedisCacheAvaLanche() throws InterruptedException {


        // 请求总数
        int clientTotal = 5000;
        // 同时并发执行的线程数
        int threadTotal = 200;

        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);

        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();

                    // 加随机数
                    String key = "CacheAvaLanche:" + Math.random();
                    int value = (int) (Math.random() * 1000);
                    redisTemplate.opsForValue().set(key, value, value, TimeUnit.SECONDS);

                    count.getAndIncrement();
                    System.out.println("count:" + count.get());
                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //闭锁减一
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行

        executorService.shutdown();
    }

    /**
     * 缓存穿透
     * 解决方案
     * 通过Bloom 过滤器拦截。
     * 将无效 key 保存到 Redis 中
     * 缓存空结果，但是缓存的有效时间很短，不超过5分钟。
     */
    @Test
    public void testRedisCachePenetration() {
        int size = 1000000;
        //布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.001);

        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        List<Integer> list = new ArrayList<Integer>(1000);
        for (int i = size + 1; i < size + 10000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        System.out.println("误判数量：" + list.size());

    }

    /**
     * 缓存击穿
     * 解决方案
     * 互斥锁：业界更常见的做法是使用互斥锁。简单地说,当缓存失效时，并不是立即加载数据库，而是先设置一个互斥锁（该互斥锁可以是Java的内存锁，也可以是通过Redis提供的SETNX实现一个互斥锁），当互斥锁获取成功，则执行DB查询并缓存
     * SETNX是“set if not exists”的缩写，它只在key不存在的时候才会设置缓存，可以用来实现锁的效果。
     */
    @Test
    public void testRedisCacheBreakdown() {

    }

}
