# spring-redis-crud-api
A hands-on learning project demonstrating Redis caching in a Spring Boot CRUD application with MySQL persistence.



I used the cache-aside pattern with Redis. Frequently accessed data is cached with a TTL(Time to Live) of 10 minutes using @Cacheable. When records are updated or deleted, the corresponding cache entries are refreshed or evicted using @CachePut and @CacheEvict to prevent stale data.
