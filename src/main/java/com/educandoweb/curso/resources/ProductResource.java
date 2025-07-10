package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Product>> findAll() {
		List<Product> listProd = productService.findAll();
		return ResponseEntity.ok().body(listProd);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product prod = productService.findById(id);
		return ResponseEntity.ok().body(prod);
	}
}
