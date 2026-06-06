package com.boot.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.redis.entity.Product;

@Repository
public interface IProductRepositoty extends JpaRepository<Product, Long> {

}
