package com.api.estoqueControl.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.estoqueControl.models.Produto;
import com.api.estoqueControl.repositores.ProdutoRepository;

@Service
public class ProdutoService {
 
        final ProdutoRepository produtoRepository;

        public ProdutoService(ProdutoRepository produtoRepository){
                this.produtoRepository = produtoRepository;
        }


        @Transactional
        public Object save(Produto parkingSpotModel) 
        {
            return produtoRepository.save(parkingSpotModel);
        }


        public List<Produto> findAll() 
        {
            return produtoRepository.findAll();
        }


        public Optional<Produto> findById(UUID id) 
        {
            return produtoRepository.findById(id);
        }

        @Transactional
        public void delete(Produto parkingSpotModel) 
        {
            produtoRepository.delete(parkingSpotModel);
        }
        

}
