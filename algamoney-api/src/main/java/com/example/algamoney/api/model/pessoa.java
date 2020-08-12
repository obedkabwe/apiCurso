package com.example.algamoney.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="pessoa")




public class pessoa {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long codigo;
private String nome;
private String endereco;
private String logradouro;
private String complemento;
private String bairo;
private String cep;
private String cidade;
private String estado;

public String getBairo() {
	return bairo;
}
public void setBairo(String bairo) {
	this.bairo = bairo;
}



public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getLogradouro() {
	return logradouro;
}
public void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
}
public String getComplemento() {
	return complemento;
}
public void setComplemento(String complemento) {
	this.complemento = complemento;
}

public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
	
	
	
	
	
	
}
