package com.java9r.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java9r.dao.ProductDAO;

import entites.com.Product;

import org.springframework.transaction.annotation.Propagation;

@Service("ProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Autowired 
	private ProductDAO productDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Product> findAll() {
		logger.debug(">> getproductlist ");
		return productDAO.findAll();
	}

	@Override
	public Product find(int id) {
		return productDAO.find(id);
	}

	 
}
