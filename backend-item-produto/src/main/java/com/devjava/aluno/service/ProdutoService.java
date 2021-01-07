package com.devjava.aluno.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devjava.aluno.model.Produto;
import com.devjava.aluno.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id).get();
	}
	
	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto atualizar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void remover(Produto produto) {
		produtoRepository.delete(produto);
	}
}
