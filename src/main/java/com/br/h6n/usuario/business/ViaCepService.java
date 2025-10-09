package com.br.h6n.usuario.business;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.br.h6n.usuario.infrastructure.clients.ViaCepClient;
import com.br.h6n.usuario.infrastructure.clients.ViaCepDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepDTO buscarDadosEndereco(String cep) {
        return viaCepClient.buscarDadosEndereco(processaCep(cep));
    }

    private String processaCep(String cep) {
        String cepFormatado = cep.replaceAll("[^0-9]", "");
        if (!Objects.equals(cepFormatado.length(), 8)) {
            throw new IllegalArgumentException("Tamanho do CEP inválido");
        }
        return cepFormatado;
    }
}
