package com.api.estoqueControl.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(name = "nome")
   private String nome;
   @Column(name = "validade")
   private String validade;
   @Column(name = "fornecedor")
   private String fornecedor;
   @Column(name = "preco")
   private String preco;
public UUID getId() {
    return id;
}
public void setId(UUID id) {
    this.id = id;
}
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
