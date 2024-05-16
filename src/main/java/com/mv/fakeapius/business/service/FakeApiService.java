package com.mv.fakeapius.business.service;

import com.mv.fakeapius.apiv1.dto.ProductsDTO;
import com.mv.fakeapius.business.converter.ProductConverter;
import com.mv.fakeapius.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;
    private final ProductConverter converter;
    private final ProductService service;

    public List<ProductsDTO> findAllProducts(){
        try {
            List<ProductsDTO> dto = client.findAllProducts();
            dto.forEach(product -> {
                        Boolean existsTitle =  service.existsByTitle(product.getTitle());

                        if(existsTitle.equals(false)){
                            service.saveProduct(converter.toEntity(product));
                        }
                        throw new RuntimeException("Product already registered in the database: " + product.getTitle());
                    }
            );

            return converter.toListDTO(service.findAllProduct());
        } catch (Exception e){
            throw new RuntimeException("Error when searching and saving products in the database");
        }

    }
}
