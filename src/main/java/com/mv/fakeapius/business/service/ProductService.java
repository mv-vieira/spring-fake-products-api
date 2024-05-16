package com.mv.fakeapius.business.service;

import com.mv.fakeapius.infrastructure.entities.ProductEntity;
import com.mv.fakeapius.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository repository;


    public ProductEntity saveProduct(ProductEntity product){
        try {
            return repository.save(product);
        } catch (Exception e){
            throw new RuntimeException("Error saving product" + e);
        }
    }

    public List<ProductEntity> findAllProduct(){
        try{
            return repository.findAll();
        } catch (Exception e){
            throw new RuntimeException("Error when performing data search");
        }
    }

    public Boolean existsByTitle(String title){
        try{
            return repository.existsByTitle(title);
        } catch (Exception e){
            throw new RuntimeException("Error when searching for product with title: " + title);
        }
    }
}
