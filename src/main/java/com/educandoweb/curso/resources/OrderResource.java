package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.services.OrderService;

@RestController // Setar que é a classe é um Recurso Web q é implementado por 1 Controlador REST
@RequestMapping(value = "/orders") // Nome e caminho do recurso.
public class OrderResource {

	@Autowired
	private OrderService OrderService;
	
	@GetMapping // Req. GET | //Endpoint p/ acessar os usuários
	public ResponseEntity<List<Order>> findAll() { //Tipo p/ retornar request 
		List<Order> list = OrderService.findAll();
		return ResponseEntity.ok().body(list); // ok() -> Retornar a resposta c/ sucesso | body() -> corpo da resposta.
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order u = OrderService.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
