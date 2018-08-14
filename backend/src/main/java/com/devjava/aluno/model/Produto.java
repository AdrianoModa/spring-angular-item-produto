package com.devjava.aluno.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nomeProduto;
	
	@Column
	private float valorProduto;
	
	@Column
	private boolean emEstoque;
	
	@Column
	private String serieProduto;
	
	/* Getters e Setters */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	public boolean isEmEstoque() {
		return emEstoque;
	}
	public void setEmEstoque(boolean emEstoque) {
		this.emEstoque = emEstoque;
	}
	public String getSerieProduto() {
		return serieProduto;
	}
	public void setSerieProduto(String serieProduto) {
		this.serieProduto = serieProduto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", valorProduto=" + valorProduto + ", emEstoque="
				+ emEstoque + ", serieProduto=" + serieProduto + "]";
	}
}