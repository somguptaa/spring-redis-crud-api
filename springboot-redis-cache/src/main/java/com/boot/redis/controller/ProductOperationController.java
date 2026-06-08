package com.boot.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.redis.entity.Product;
import com.boot.redis.service.IProductServiceMgmtService;

@RestController
@RequestMapping("/product-api")
public class ProductOperationController {
	@Autowired
	private IProductServiceMgmtService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		Product registerProduct = service.registerProduct(product);
		return new ResponseEntity<String>(registerProduct.toString() + " Is Saved", HttpStatus.CREATED);
	}

	@GetMapping("find/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = service.getProductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/Findall")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = service.getAllProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updateProduct = service.updateProduct(id, product);
		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		String msg = service.deleteProductById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}