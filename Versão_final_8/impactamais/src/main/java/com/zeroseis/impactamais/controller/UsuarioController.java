package com.zeroseis.impactamais.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeroseis.impactamais.model.UserLogin;
import com.zeroseis.impactamais.model.Usuario;
import com.zeroseis.impactamais.repository.UsuarioRepository;
import com.zeroseis.impactamais.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Authentication(@RequestBody Optional<UserLogin> user){		
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario > Post(@RequestBody Usuario email){		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(email));
	}		
		
	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario email){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(email));		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}

