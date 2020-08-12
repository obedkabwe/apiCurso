package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.model.pessoa;
import com.example.algamoney.api.repository.pessoaRepository;

@RestController
@RequestMapping("/pessoas")



public class pessoaResource {
    
	@Autowired
	private pessoaRepository pessoaRepository;
	
	@GetMapping
	public List<pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody    pessoa pessoa, HttpServletResponse response) {
	pessoa pessoaSalva=	pessoaRepository.save(pessoa);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(pessoaSalva.getCodigo()).toUri();	
	response.setHeader("location", uri.toASCIIString());	
	}
	
	
	
	@GetMapping("/{codigo}")
	
	public pessoa buscarPeloCodigo(@PathVariable  Long codigo) {
		 pessoa pessoaExample = new pessoa();
		    pessoaExample.setCodigo(codigo);
		    
		    Example<pessoa> example = Example.of(pessoaExample);
		    
		    return this.pessoaRepository.findOne(example).orElse(null);

	}
	
	
	
	
	
	
}
