package com.devjava.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devjava.aluno.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
