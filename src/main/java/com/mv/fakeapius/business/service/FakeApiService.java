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
        List<ProductsDTO> dto = client.findAllProducts();
        dto.forEach(product -> service.saveProduct(converter.toEntity(product)));
        return dto;
    }
}
