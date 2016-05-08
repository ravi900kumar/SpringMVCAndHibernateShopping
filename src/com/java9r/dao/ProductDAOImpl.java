package com.java9r.dao;

import entites.com.*;


import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


@Repository
public class ProductDAOImpl implements ProductDAO {
	private static Logger logger = Logger.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {

		logger.debug(">> getproductlist ");
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		 
	}

	@Override
	public Product find(int id) {
		
		return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("id", id))
				.uniqueResult();

	}

 
}
