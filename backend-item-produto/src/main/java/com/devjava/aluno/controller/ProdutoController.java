package com.devjava.aluno.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.devjava.aluno.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarTodos(){
		return produtoService.buscarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		return ResponseEntity.status(200).body(produtoService.buscarPorId(id));
	}

	@PostMapping
	public Produto adicionar(@RequestBody @Validated Produto produto){
		return produtoService.inserir(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Validated @RequestBody Produto produto){
		produto.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizar(produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id, Produto produto){
		produtoService.remover(produto);
		return ResponseEntity.status(HttpStatus.valueOf(200)).body("O produto foi removido com sucesso!");
	}
}