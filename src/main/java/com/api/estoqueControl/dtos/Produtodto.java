package com.api.estoqueControl.dtos;

import javax.validation.constraints.NotBlank;


public class Produtodto {

    @NotBlank
    private String nome;

    @NotBlank
   
    private String validade;

    @NotBlank
    private String fornecedor;

    @NotBlank
    private String preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
}
