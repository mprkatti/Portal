package com.mpk.testportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpk.testportal.model.Product;
import com.mpk.testportal.service.ProductService;
import com.mpk.testportal.service.ProductServiceClient;
import com.mpk.testportal.shared.CartDto;
import com.mpk.testportal.shared.CartItemDto;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	private CartDto cart = null;
    private List<Product>  productList =null;

	@GetMapping
	public String getAllProducts(Model model) {
		

		if(productList == null)
		  productList = productService.getAllProductsFromRemoteService();

		
		model.addAttribute("products", productList);

		if (cart != null && cart.getItems() != null) {
			model.addAttribute("itemCount", cart.getItems().size());
		}

 
		return "products";

	}

	@GetMapping("/{id}")
	public String getProductById(@PathVariable String id, Model model) {

		Product product = productService.getProductById(id);

		model.addAttribute("product", product);
		model.addAttribute("itemCount", (cart == null) ? 0 : cart.getItems().size());
		return "product";

	}

	@GetMapping("/cart")
	public String getCart(Model model) {

		if (cart == null) {
			cart = getNewCart();
		}

		model.addAttribute("cart", cart);
		model.addAttribute("itemCount", (cart == null) ? 0 : cart.getItems().size());
		return "cart";

	}

	@PostMapping("/{itemId}")

	public String addToCart(Model model, @PathVariable String itemId) {
		logger.info("Inside addtocart ..");
		CartItemDto item = new CartItemDto();
		Product product = productService.getProductById(itemId);

		item.setItemId(itemId);
		item.setDescription(product.getDescription());
		item.setPrice(product.getPrice());
		item.setQuantity(1);
		item.setName(product.getName());

		if (cart == null) {
			cart = getNewCart();
		}

		if (cart.getItems() == null) {

			List<CartItemDto> cartItems = new ArrayList<>();
			cartItems.add(item);
			cart.setItems(cartItems);
		} else {

			cart.getItems().add(item);
		}
		cart.setCartTotal(cart.getCartTotal() + item.getPrice());
		model.addAttribute("cart", cart);
		model.addAttribute("itemCount", cart.getItems().size());

		return "cart";
	}

	private CartDto getNewCart() {

		CartDto cart = new CartDto();
		cart.setId(UUID.randomUUID().toString());
		cart.setUserId("demo_mpk");
		cart.setUserName("Mahantesh Prasad Katti");
		cart.setCartTotal(0.0);
		return cart;

	}

}
