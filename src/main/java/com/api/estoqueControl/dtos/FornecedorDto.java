package com.api.estoqueControl.dtos;

import javax.validation.constraints.NotBlank;


public class FornecedorDto {

    @NotBlank
    private String nome;

    @NotBlank
   
    private String cnpj;

    @NotBlank
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

   

   
}
