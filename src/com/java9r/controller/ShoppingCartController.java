package com.java9r.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java9r.service.ProductService;

import entites.com.Items;

@Controller
@RequestMapping(value = "/shoppingcart")
public class ShoppingCartController {
	@Autowired
	private ProductService pm;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ordernow/{id}", method = RequestMethod.GET)
	public String ordernow(@PathVariable(value = "id") int id, ModelMap mm, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Items> cart = new ArrayList<Items>();
			cart.add(new Items(this.pm.find(id), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Items> cart = (List<Items>) session.getAttribute("cart");

			// using method isExisting here
			int index = isExisting(id, session);
			if (index == -1)
				cart.add(new Items(this.pm.find(id), 1));
			else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}

			session.setAttribute("cart", cart);
		}

		return "cart"; // page name
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") int id, HttpSession session) {
		List<Items> cart = (List<Items>) session.getAttribute("cart");

		int index = isExisting(id, session);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "cart";
	}

	@SuppressWarnings("unchecked")
	private int isExisting(int id, HttpSession session) {

		List<Items> cart = (List<Items>) session.getAttribute("cart");

		for (int i = 0; i < cart.size(); i++)

			if (cart.get(i).getProduct().getId() == id)
				return i;

		return -1;
	}

}