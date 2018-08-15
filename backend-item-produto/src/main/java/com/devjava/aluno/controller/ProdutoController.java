package com.devjava.aluno.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.client.RestClientException;
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
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		Produto produto = produtoRepository.findOne(id);
		Optional.ofNullable(produto).orElseThrow(() -> new RestClientException("O livro não existe"));		
		return ResponseEntity.status(200).body(produto);
	}

	@PostMapping
	public Produto adicionar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
		Produto produtoExistente = produtoRepository.findOne(id);
		Optional.ofNullable(produtoExistente).orElseThrow(() -> new RestClientException("O livro não existe"));
		BeanUtils.copyProperties(produto, produtoExistente, "id");
		produto = produtoRepository.save(produtoExistente);
		return ResponseEntity.status(HttpStatus.OK).body("O Produto foi atualizado com sucesso!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id, Produto produto){
		Produto produtoExistente = produtoRepository.findOne(id);
		Optional.ofNullable(produtoExistente).orElseThrow(() -> new RestClientException("Impossível deletar! O livro não existe"));
		produtoRepository.delete(produto.getId());
		return ResponseEntity.status(HttpStatus.valueOf(200)).body("O livro foi removido com sucesso");
	}
}