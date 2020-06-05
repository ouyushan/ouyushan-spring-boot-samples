## Jedis

直接连接 redis server。在多线程环境下是非线程安全的，需要使用连接池，为每个Jedis实例增加物理连接。

## Lettuce

连接基于Netty，连接实例可以在多个线程间并发访问。因为连接实例是线程安全的，所以一个连接实例就可以满足多线程环境下的并发访问。



## 缓存管理器

- RedisCacheManager
- SimpleCacheManager
- NoOpCacheManager
- ConcurrentMapCacheManager
- CompositeCacheManager
- EhCacheCacheManager

## 序列化器

- GenericToStringSerializer：使用Spring转换服务进行序列化；
- JacksonJsonRedisSerializer：使用Jackson 1，将对象序列化为JSON；
- Jackson2JsonRedisSerializer：使用Jackson 2，将对象序列化为JSON；
- JdkSerializationRedisSerializer：使用Java序列化；
- OxmSerializer：使用Spring O/X映射的编排器和解排器（marshaler和unmarshaler）实现序列化，用于XML序列化；
- StringRedisSerializer：序列化String类型的key和value。