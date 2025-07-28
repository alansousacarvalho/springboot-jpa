package com.educandoweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.services.UserService;

@RestController // Setar que a classe é um Recurso Web q é implementado por 1 Controlador REST
@RequestMapping(value = "/users") // Nome e caminho do recurso.
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping // Req. GET | //Endpoint p/ acessar os usuários
	public ResponseEntity<List<User>> findAll() { //Tipo p/ retornar request 
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list); // ok() -> Retornar a resposta c/ sucesso | body() -> corpo da resposta.
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User u = userService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		User user = userService.update(id, obj);
		return ResponseEntity.ok().body(user);
	}
}
