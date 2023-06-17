package com.programingtechie.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programingtechie.productservice.dto.ProductRequest;
import com.programingtechie.productservice.dto.ProductResponse;
import com.programingtechie.productservice.model.Product;
import com.programingtechie.productservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		Product product = new Product().builder().name(productRequest.getName())
				.description(productRequest.getDescription()).price(productRequest.getPrice()).build();
		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products=productRepository.findAll();
		return products.stream().map(this::mapProductResponse).toList();
//		return products;
	}
	private ProductResponse mapProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
			     .description(product.getDescription())
			     .price(product.getPrice()).build();
	}
}
