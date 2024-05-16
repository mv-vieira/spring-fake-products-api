package com.mv.fakeapius.business.converter;

import com.mv.fakeapius.apiv1.dto.ProductsDTO;
import com.mv.fakeapius.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class ProductConverter {

    public ProductEntity toEntity(ProductsDTO dto){
        return ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .title(dto.getTitle())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .image(dto.getImage())
                .inclusionDate(LocalDateTime.now())
                .build();
    }

    public ProductsDTO toDTO(ProductEntity entity){
        return ProductsDTO.builder()
                .entityId(entity.getId())
                .title(entity.getTitle())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .image(entity.getImage())
                .build();
    }

    public List<ProductsDTO> toListDTO(List<ProductEntity> entityList){
        return entityList.stream().map(this::toDTO).toList();
    }
}
