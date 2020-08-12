package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.model.lancamento;

import com.example.algamoney.api.repository.lancamentoRepository;

@RestController
@RequestMapping("/lancamentos")

public class lancamentoResource {

@Autowired
	private lancamentoRepository lancamentoRepository;
	
	
	@GetMapping
	
 public List<lancamento> listar(){
	 return lancamentoRepository.findAll();
 }

 
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
public void salvar(@RequestBody   lancamento lancamento, HttpServletResponse response) {
	lancamento lancamentoSalva = lancamentoRepository.save(lancamento);
	 URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(lancamentoSalva.getCodigo()).toUri();
	 response.setHeader("location", uri.toASCIIString());
 }
 
 
 @GetMapping("/{codigo}")
 
 public lancamento buscarCodigo(@PathVariable Long codigo) {
	 lancamento lancamentoExample = new lancamento();
	    lancamentoExample.setCodigo(codigo);
	    
	    Example<lancamento> example = Example.of(lancamentoExample);
	    
	    return this.lancamentoRepository.findOne(example).orElse(null);
 }
 
 
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		lancamentoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	
	public lancamento atualizar(Long codigo, lancamento lancamento) {

		  lancamento pessoaSalva = this.lancamentoRepository.findById(codigo)
		      .orElseThrow((() -> new EmptyResultDataAccessException(1)));

		  BeanUtils.copyProperties(lancamento, pessoaSalva, "codigo");

		  return this.lancamentoRepository.save(pessoaSalva);
		}
}