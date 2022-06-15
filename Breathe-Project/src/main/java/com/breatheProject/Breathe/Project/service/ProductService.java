package com.breatheProject.Breathe.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breatheProject.Breathe.Project.entity.Product;
import com.breatheProject.Breathe.Project.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getproductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getproductByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		String previousCount = Long.toString(repository.count());
		repository.deleteById(id);
		return "product is removed: " + id + "; the current count is: " + previousCount;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct =  repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		return repository.save(existingProduct);
	}
}
