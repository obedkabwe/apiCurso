package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.pessoa;

public interface pessoaRepository extends JpaRepository<pessoa, Long> {

	
}
