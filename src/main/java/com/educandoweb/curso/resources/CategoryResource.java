package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.services.CategoryService;

@RestController // Setar que é a classe é um Recurso Web q é implementado por 1 Controlador REST
@RequestMapping(value = "/categories") // Nome e caminho do recurso.
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping // Req. GET | //Endpoint p/ acessar os usuários
	public ResponseEntity<List<Category>> findAll() { //Tipo p/ retornar request 
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list); // ok() -> Retornar a resposta c/ sucesso | body() -> corpo da resposta.
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category u = categoryService.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
