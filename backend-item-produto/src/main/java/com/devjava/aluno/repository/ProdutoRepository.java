package com.devjava.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devjava.aluno.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
