package com.api.estoqueControl.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.estoqueControl.dtos.FornecedorDto;
import com.api.estoqueControl.models.Fornecedor;
import com.api.estoqueControl.services.FornecedorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins ="*",maxAge=3600)
@RequestMapping("fornecedores")
public class FornecedorController {

        final FornecedorService fornecedorService;

        public FornecedorController(FornecedorService fornecedorService) {
             this.fornecedorService= fornecedorService;
        }

        
        @PostMapping
        public ResponseEntity<Object>saveFornecedor(@RequestBody @Valid FornecedorDto fornecedorDto){
            
        
            
            var fornecedorModel = new Fornecedor();
            if(fornecedorService.existsBycnpj(fornecedorDto.getCnpj())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: extiste um fornecedor com o CNPJ já cadastrado!");
            }

            BeanUtils.copyProperties(fornecedorDto, fornecedorModel);
           

            return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.save(fornecedorModel));

        }
    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllProducts(){


        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnProducts(@PathVariable(value = "id") UUID id){
        Optional<Fornecedor> produtoModelOptional = fornecedorService.findById(id);
        if(!produtoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor Not Found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){

        Optional<Fornecedor> parkingSpotModelOptional = fornecedorService.findById(id);
       
        if(!parkingSpotModelOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor Not Found");
        }

        fornecedorService.delete(parkingSpotModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor deleted Sucefully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
     @RequestBody @Valid FornecedorDto fornecedorDto)
     {
        Optional<Fornecedor> fornecedorModelOptional = fornecedorService.findById(id);
        if(!fornecedorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor Not Found");
        }

        var fornecedorModel = new Fornecedor();
        BeanUtils.copyProperties(fornecedorDto, fornecedorModel);
        fornecedorModel.setId(fornecedorModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedorModel));
    }
    
    

    
}
