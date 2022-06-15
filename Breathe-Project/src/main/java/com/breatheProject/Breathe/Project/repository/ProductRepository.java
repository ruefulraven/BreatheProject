package com.breatheProject.Breathe.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.breatheProject.Breathe.Project.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
