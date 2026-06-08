## What I Learned About Redis

This project helped me gain practical experience with Redis and understand how caching works in real-world Spring Boot applications.

### Understanding Redis

* Redis stands for **Remote Dictionary Server**.
* Redis is an **in-memory key-value data store**.
* Data is stored in RAM, making read and write operations extremely fast.
* Redis can be used as:

  * Cache Layer
  * NoSQL Key-Value Store
  * Message Broker (Pub/Sub)

In this project, Redis is used as a **caching solution**.

---

### Why Redis is Needed

Without caching, every request requires communication with the database.

```text
Client Request
      |
Spring Boot Application
      |
      v
MySQL Database
```

For frequently requested data, repeated database queries increase:

* Response time
* Database workload
* Network traffic

Redis helps solve these problems by storing frequently accessed data in memory.

---

### Cache-First Strategy

Through this project, I learned how the Cache-Aside Pattern works.

#### First Request

```text
Client
   |
   v
Application
   |
Redis Cache (Miss)
   |
Database
   |
Store Data in Cache
   |
Response
```

#### Subsequent Requests

```text
Client
   |
   v
Application
   |
Redis Cache (Hit)
   |
Response
```

This significantly reduces database access and improves application performance.

---

### Spring Cache Integration

I learned how Spring Boot integrates with Redis using:

```java
@EnableCaching
```

to enable caching support in the application.

I also learned how:

```java
@Cacheable(cacheNames = "ProdCache")
```

stores the result of a method in Redis and automatically returns cached data for future requests.

---

### Redis Cache Naming

In this project, cache data is stored under:

```text
ProdCache
```

I learned that cache names act as logical containers for cached data and help organize cache entries efficiently.

---

### Redis Configuration

I learned how Spring Boot automatically creates Redis connections using configuration properties.

```properties
spring.cache.type=redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

Spring Boot's auto-configuration mechanism establishes communication with the Redis server without requiring extensive manual configuration.

---

### Local Cache vs Distributed Cache

I learned the difference between:

#### Local Cache

* Used by a single application instance.
* Cache data is not shared with other applications.

#### Distributed Cache

* Shared across multiple applications or microservices.
* Provides a centralized caching mechanism.

Redis can be used as both Local Cache and Distributed Cache, but it is most commonly used as a Distributed Cache in enterprise applications.

---

### Benefits of Redis Observed in This Project

* Faster response times.
* Reduced database calls.
* Reduced network round trips.
* Better application scalability.
* Improved performance for frequently accessed data.
* Seamless integration with Spring Boot.

---

### Key Redis Concepts Practiced

* Redis Server Setup
* Redis Configuration in Spring Boot
* Spring Cache Abstraction
* Cache-Aside Pattern
* Cache Hit and Cache Miss
* Distributed Caching Concepts
* Key-Value Storage
* In-Memory Data Processing
* Performance Optimization using Caching

---

### Key Takeaway

The biggest learning from this project was understanding how Redis acts as a high-speed caching layer between the application and database. By serving frequently requested data directly from memory, Redis significantly improves application performance and reduces unnecessary database interactions.
