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
@Table(name = "TB_FORNECEDORES")
public class Fornecedor implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(name = "nome")
   private String nome;
   @Column(name = "cnpj")
   private String cnpj;
   @Column(name = "telefone")
   private String telefone;
  
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
public String getCnpj() {
    return cnpj;
}
public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
}
public String getTelefone() {
    return telefone;
}
public void setTelefone(String telefone) {
    this.telefone = telefone;
}
    
}
