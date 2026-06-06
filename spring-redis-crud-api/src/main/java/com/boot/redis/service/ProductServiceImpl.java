package com.boot.redis.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.boot.redis.entity.Product;
import com.boot.redis.exception.ProductIdNotFoundException;
import com.boot.redis.repository.IProductRepositoty;


@Service
public class ProductServiceImpl implements IProductServiceMgmtService{
	@Autowired
	private IProductRepositoty repository;

	@Override
	public Product registerProduct(Product product) {
		return repository.save(product);
	}

	@Override
	@Cacheable(cacheNames = "ProdCache")
	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ProductIdNotFoundException("Invalid Id"));
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
	Product existingProduct=getProductById(id);
	BeanUtils.copyProperties(product,existingProduct);
		return existingProduct;
	}

	@Override
	public String deleteProductById(Long id) {
		repository.deleteById(id);
		return "Product Is Deleted Successfully";
		
	}

}
