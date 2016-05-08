package com.java9r.dao;

import java.util.List;

import entites.com.Product;

 

public interface ProductDAO {

	

	public List<Product> findAll();
	
	public Product find(int id);
	

}
