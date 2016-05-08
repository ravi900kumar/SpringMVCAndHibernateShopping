package com.java9r.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.java9r.service.ProductService;
import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String index(ModelMap mm) {

		logger.debug(">> getproductlist ");

		mm.put("listproduct", productService.findAll());

		logger.debug(">> getproductlist success ");
		return "index";
	}

}
