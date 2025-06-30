package com.educandoweb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.User;

@RestController // Setar que é a classe é um Recurso Web q é implementado por 1 Controlador REST
@RequestMapping(value = "/users") // Nome e caminho do recurso.
public class UserResource {

	@GetMapping // Req. GET | //Endpoint p/ acessar os usuários
	public ResponseEntity<User> findAll() { //Tipo p/ retornar request 
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u); // ok() -> Retornar a resposa c/ sucesso | body() -> corpo da resposta.
	} 
}
