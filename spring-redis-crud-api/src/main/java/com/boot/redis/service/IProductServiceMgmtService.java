package com.boot.redis.service;

import java.util.List;

import com.boot.redis.entity.Product;

public interface IProductServiceMgmtService {
	public Product registerProduct(Product product);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
	public Product updateProduct(Long id, Product product);
	public String deleteProductById(Long id);

}
