package com.example.algamoney.api.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="lancamento")


public class lancamento {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)   

private Long codigo;
private String descricao;

@Column(name = "data_vencimento")
private LocalDate data_vencimento;

@Column(name = "data_pagamento")
private LocalDate data_pagamento;

private BigDecimal valor;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
	lancamento other = (lancamento) obj;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
	return true;
}

public Long getCodigo() {
	return codigo;
}

public void setCodigo(Long codigo) { 
	this.codigo = codigo;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public LocalDate getData_vencimento() {
	return data_vencimento;
}

public void setData_vencimento(LocalDate data_vencimento) {
	this.data_vencimento = data_vencimento;
}

public LocalDate getData_pagamento() {
	return data_pagamento;
}

public void setData_pagamento(LocalDate data_pagamento) {
	this.data_pagamento = data_pagamento;
}

public BigDecimal getValor() {
	return valor;
}

public void setValor(BigDecimal valor) {
	this.valor = valor;
}

public TipoLancamento getTipo() {
	return tipo;
}

public void setTipo(TipoLancamento tipo) {
	this.tipo = tipo;
}

public categoria getCategoria() {
	return categoria;
}

public void setCategoria(categoria categoria) {
	this.categoria = categoria;
}

public pessoa getPessoa() {
	return pessoa;
}

public void setPessoa(pessoa pessoa) {
	this.pessoa = pessoa;
}

@Enumerated(EnumType.STRING)
private TipoLancamento tipo;

@ManyToOne
@JoinColumn(name = "codigo_categoria")
private  categoria categoria;

@ManyToOne
@JoinColumn(name = "codigo_pessoa")
private pessoa pessoa;















}
