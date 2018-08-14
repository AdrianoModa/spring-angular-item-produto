package com.devjava.aluno.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.devjava.aluno.model.Produto;
import com.devjava.aluno.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("${origem-permitida}")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto listarPorId(@PathVariable Long id){
		return produtoRepository.findOne(id);
	}
	
	@PostMapping
	public Produto adicionar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
		Produto produtoExistente = produtoRepository.findOne(id);
		if(produtoExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(produto, produtoExistente, "id");
		produto = produtoRepository.save(produtoExistente);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id, Produto produto){
		Produto produtoExistente = produtoRepository.findOne(id);
		if (produtoExistente == null) {
			ResponseEntity.notFound().build();
		}
		produtoRepository.delete(produto.getId());
		return ResponseEntity.noContent().build();
	}
}