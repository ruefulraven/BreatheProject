package com.breatheProject.Breathe.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.breatheProject.Breathe.Project.entity.Product;
import com.breatheProject.Breathe.Project.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
	public List<Product> addProduct(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}
	
	@GetMapping("/products")
	public List<Product> findByAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/productbyid/{id}")
	public Product findByProductId(@PathVariable int id) {
		return service.getproductById(id);
	}
	
	
	@GetMapping("/productbyname/{name}")
	public Product findByProductId(@PathVariable String name) {
		return service.getproductByName(name);
	}
	
	@PutMapping("/updateproduct")
	public Product updateProduct (@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
