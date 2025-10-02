package com.br.h6n.usuario.business.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.br.h6n.usuario.business.dto.EnderecoDTO;
import com.br.h6n.usuario.business.dto.TelefoneDTO;
import com.br.h6n.usuario.business.dto.UsuarioDTO;
import com.br.h6n.usuario.infrastructure.entity.Endereco;
import com.br.h6n.usuario.infrastructure.entity.Telefone;
import com.br.h6n.usuario.infrastructure.entity.Usuario;

@Component
public class UsuarioConverter {
    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return  Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream()
                .map(this::paraTelefone)
                .toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public Usuario paraUsuarioDTO(Usuario usuario){
        return  Usuario.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuario.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEnderecoDTO(List<Endereco> enderecos){
        List<Endereco> enderecosDTOS = new ArrayList<>();
        for(Endereco endereco : enderecos){
            enderecosDTOS.add(paraEnderecoDTO(endereco));
        }
        return enderecosDTOS;
    }

    public Endereco paraEnderecoDTO(Endereco endereco){
        return Endereco.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefonesDTO(List<Telefone> telefones){
        return telefones.stream()
                .map(this::paraTelefoneDTO)
                .toList();
    }

    public Telefone paraTelefoneDTO(Telefone telefone){
        return Telefone.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}
