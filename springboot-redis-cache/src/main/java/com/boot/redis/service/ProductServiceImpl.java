package com.boot.redis.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.boot.redis.entity.Product;
import com.boot.redis.exception.ProductIdNotFoundException;
import com.boot.redis.repository.IProductRepositoty;

@Service
public class ProductServiceImpl implements IProductServiceMgmtService {

    @Autowired
    private IProductRepositoty repository;

    @Override
    public Product registerProduct(Product product) {
        return repository.save(product);
    }

    @Override
    @Cacheable(value = "ProdCache", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("Fetching from DB...");
        return repository.findById(id)
                .orElseThrow(() -> new ProductIdNotFoundException("Invalid Id"));
    }

    @Override
    @Cacheable(value = "ProdCache", key = "'allProducts'")
    public List<Product> getAllProducts() {
        System.out.println("Fetching all products from DB...");
        return repository.findAll();
    }

    @Override
    @CachePut(value = "ProdCache", key = "#id")
    @CacheEvict(value = "ProdCache", key = "'allProducts'")
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new ProductIdNotFoundException("Invalid Id"));

        BeanUtils.copyProperties(product, existingProduct, "id");

        Product updatedProduct = repository.save(existingProduct);

        return updatedProduct;
    }

    @Override
    @CacheEvict(value = "ProdCache", key = "#id")
    public String deleteProductById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductIdNotFoundException("Invalid Id"));

        repository.delete(product);

        return "Product Is Deleted Successfully";
    }
}