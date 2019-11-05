package com.mpk.testportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.mpk.testportal.model.Product;

@FeignClient(name = "products-ws", fallback = ProductServiceFallback.class)
public interface ProductServiceClient {

	@GetMapping("/products")
	public List<Product> getAllProductsFromService();

}

@Component
class ProductServiceFallback implements ProductServiceClient {

	private List<Product> list = new ArrayList<>();
	Logger logger = LoggerFactory.getLogger(ProductServiceFallback.class);

	@Override
	public List<Product> getAllProductsFromService() {

		list.add(new Product(UUID.randomUUID().toString(), "Maple TV", "Brand New Apple TV", 400.46, "Apple Inc", ""));
		list.add(new Product(UUID.randomUUID().toString(), "Macromax  Phone", "Latest MicroMax Next Gen", 250.46, "Macromax Digital Company", ""));
		list.add(new Product(UUID.randomUUID().toString(), "EcoGreen Refrigerator", "Next Gen Fridge ", 100.46, "Eco Green Co",""));

		return list;
	}

}