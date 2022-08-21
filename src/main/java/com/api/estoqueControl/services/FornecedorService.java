package com.api.estoqueControl.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.estoqueControl.models.Fornecedor;
import com.api.estoqueControl.repositores.FornecedorRepository;

@Service
public class FornecedorService {
 
        final FornecedorRepository fornecedorRepository;

        public FornecedorService(FornecedorRepository fornecedorRepository){
                this.fornecedorRepository = fornecedorRepository;
        }


        @Transactional
        public Object save(Fornecedor fornecedorModel) 
        {
            return fornecedorRepository.save(fornecedorModel);
        }


        public List<Fornecedor> findAll() 
        {
            return fornecedorRepository.findAll();
        }


        public Optional<Fornecedor> findById(UUID id) 
        {
            return fornecedorRepository.findById(id);
        }

        @Transactional
        public void delete(Fornecedor fornecedorModel) 
        {
            fornecedorRepository.delete(fornecedorModel);
        }


        public boolean existsBycnpj(String cnpj) {
             return fornecedorRepository.existsBycnpj(cnpj);
        }
        

}
