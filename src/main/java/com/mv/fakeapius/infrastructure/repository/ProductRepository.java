package com.mv.fakeapius.infrastructure.repository;


import com.mv.fakeapius.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Boolean existsByTitle(String title);
}
