package com.api.estoqueControl.repositores;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.estoqueControl.models.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

    boolean existsBycnpj(String cnpj);
   

}
