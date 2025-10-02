package com.br.h6n.usuario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.h6n.usuario.infrastructure.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
