package com.mpk.testportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpk.testportal.model.Product;

@Service
public class ProductService {

	private List<Product> list = new ArrayList<>();
	
	private Logger logger =  LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductServiceClient productServiceClient;



	public Product getProductById(String id) {
		if (list.isEmpty()) {
			list = getAllProductsFromRemoteService();
		}

		Predicate<Product> productById = p -> p.getId().equals(id);
		return list.stream().filter(productById).findFirst().orElse(null);

	}

	public List<Product> getAllProductsFromRemoteService() {

		logger.info("Before calling Product micro service  ....");
		if(list.isEmpty())
		  list = productServiceClient.getAllProductsFromService();
		logger.info("After  calling Product micro service  ....");
		return list;

	}

}
