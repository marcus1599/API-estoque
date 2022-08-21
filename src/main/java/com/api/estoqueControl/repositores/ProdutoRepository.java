package com.api.estoqueControl.repositores;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.estoqueControl.models.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {


   

}
