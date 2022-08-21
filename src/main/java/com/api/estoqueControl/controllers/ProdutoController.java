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

import com.api.estoqueControl.dtos.Produtodto;
import com.api.estoqueControl.models.Produto;
import com.api.estoqueControl.services.ProdutoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins ="*",maxAge=3600)
@RequestMapping("produtos")
public class ProdutoController {

        final ProdutoService produtoService;

        public ProdutoController(ProdutoService parkingSpotService) {
             this.produtoService= parkingSpotService;
        }

        
        @PostMapping
        public ResponseEntity<Object>saveParkingSpot(@RequestBody @Valid Produtodto produtoDto){
            
        
            
            var produtoModel = new Produto();

            BeanUtils.copyProperties(produtoDto, produtoModel);
           

            return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoModel));

        }
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProducts(){


        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnProducts(@PathVariable(value = "id") UUID id){
        Optional<Produto> produtoModelOptional = produtoService.findById(id);
        if(!produtoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtoModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){

        Optional<Produto> parkingSpotModelOptional = produtoService.findById(id);
       
        if(!parkingSpotModelOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot Not Found");
        }

        produtoService.delete(parkingSpotModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Product deleted Sucefully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
     @RequestBody @Valid Produtodto produtoDto)
     {
        Optional<Produto> produtoModelOptional = produtoService.findById(id);
        if(!produtoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products Not Found");
        }

        var produtoModel = new Produto();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        produtoModel.setId(produtoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoModel));
    }
    
    

    
}
