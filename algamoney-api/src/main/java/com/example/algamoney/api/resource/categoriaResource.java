package com.example.algamoney.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import com.example.algamoney.api.model.categoria;
import com.example.algamoney.api.repository.categoriaRepository;



@RestController
@RequestMapping("/categorias")


public class categoriaResource {

	@Autowired
	private categoriaRepository categoriaRepository;
	
	@GetMapping
	public List<categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	
	public void criar(@RequestBody  categoria categoria , HttpServletResponse response) {
	categoria categoriaSalva=categoriaRepository.save(categoria);
	URI uri =ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(categoriaSalva.getCodigo()).toUri();
	response.setHeader("Location", uri.toASCIIString());
	
		
		
	}
	
	
   @DeleteMapping("/{codigo}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void remover(@PathVariable Long codigo) {
	   
	  categoriaRepository.deleteById(codigo);
   }
   







	}


