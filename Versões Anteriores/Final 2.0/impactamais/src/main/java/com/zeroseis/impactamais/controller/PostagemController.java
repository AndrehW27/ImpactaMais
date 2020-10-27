package com.zeroseis.impactamais.controller;

import java.util.List;

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

import com.zeroseis.impactamais.model.Postagem;
import com.zeroseis.impactamais.repository.PostagemRepository;


@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	public PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/sangue/{sangue}")
	public ResponseEntity<List<Postagem>> GetBySangue(@PathVariable String sangue){
		return ResponseEntity.ok(repository.findAllBySangueContainingIgnoreCase(sangue));
	}
	
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Postagem>> GetByCidade(@PathVariable String cidade){
		return ResponseEntity.ok(repository.findAllByCidadeContainingIgnoreCase(cidade));
	}
	
//	@GetMapping("/cidade/{cidade}")
//	public ResponseEntity<Postagem> GetByCidade(@PathVariable String cidade){
//		return repository.findAllByCidadeContainingIgnoreCase(cidade)
//				.map(resp -> ResponseEntity.ok(resp))
//				.orElse(ResponseEntity.notFound().build());		
//	}	
	
//	@GetMapping("/sangue/{sangue}")
//	public ResponseEntity<Postagem> GetBySangue(@PathVariable String sangue){
//		return repository.findAllBySangueContainingIgnoreCase(sangue)
//				.map(resp -> ResponseEntity.ok(resp))
//				.orElse(ResponseEntity.notFound().build());		
//	}	

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem titulo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(titulo));		
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem titulo){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(titulo));		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
