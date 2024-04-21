package com.analiseCredito.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    private Double renda;

}
