package com.java9r.service;
import java.util.List;

import entites.com.Product;

 

public interface ProductService {

	
	public List<Product> findAll();
	
	public Product find(int id);
	
	
}
