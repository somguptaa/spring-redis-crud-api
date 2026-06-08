# Spring Boot With Redis Cache

## Overview

A Spring Boot REST application that demonstrates CRUD operations on Product entities using MySQL as the primary database and Redis as the caching layer.

The application uses Spring Cache abstraction with Redis to improve performance by reducing database access for frequently requested product data.

---

## Features

* Create Product
* Get Product By ID
* Get All Products
* Update Product
* Delete Product
* MySQL Database Integration
* Redis Caching Support
* Spring Data JPA
* Exception Handling
* RESTful API Design
* Lombok Integration

---

## Technology Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Cache
* Redis
* MySQL
* Lombok
* Maven

---

## Project Structure

```text
src/main/java
│
├── controller
│   └── ProductOperationController
│
├── entity
│   └── Product
│
├── repository
│   └── IProductRepositoty
│
├── service
│   ├── IProductServiceMgmtService
│   └── ProductServiceImpl
│
├── exception
│   └── ProductIdNotFoundException
│
└── SpringRedisCrudApiApplication
```

---

## Product Entity

```java
Product
{
    Long id;
    String name;
    Double price;
    Double quantity;
}
```

Database Table:

```sql
PRODUCT_INFO
```

---

## API Endpoints

### Save Product

**POST**

```http
/product-api/save
```

Request Body:

```json
{
  "name": "Laptop",
  "price": 59999.99,
  "quantity": 10
}
```

---

### Get Product By Id

**GET**

```http
/product-api/find/{id}
```

Example:

```http
/product-api/find/1
```

---

### Get All Products

**GET**

```http
/product-api/Findall
```

---

### Update Product

**PUT**

```http
/product-api/update/{id}
```

Request Body:

```json
{
  "name": "Gaming Laptop",
  "price": 75000,
  "quantity": 5
}
```

---

### Delete Product

**DELETE**

```http
/product-api/delete/{id}
```

Example:

```http
/product-api/delete/1
```

---

## Redis Caching

Redis is configured as the cache provider for the application.

Cache Name:

```text
ProdCache
```

When a product is requested by ID:

1. Application checks Redis cache.
2. If data exists, it is returned directly.
3. If data does not exist, it is fetched from MySQL.
4. Retrieved data is stored in Redis for future requests.

---

## Database Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/redis_app
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=********
```

---

## Redis Configuration

```properties
spring.cache.type=redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

---

## Sample Product JSON

```json
{
  "name": "Smartphone",
  "price": 25000,
  "quantity": 15
}
```

---

## Exception Handling

Custom Exception:

```java
ProductIdNotFoundException
```

Thrown when a product is not found for the provided ID.

---

## Future Enhancements

* Docker Support
* Pagination and Sorting
* Spring Security Integration

---

## Author

Developed using Spring Boot, Redis, and MySQL to demonstrate high-performance CRUD operations with caching support.
