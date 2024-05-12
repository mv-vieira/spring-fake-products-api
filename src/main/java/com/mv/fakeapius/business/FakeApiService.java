package com.mv.fakeapius.business;

import com.mv.fakeapius.apiv1.dto.ProductsDTO;
import com.mv.fakeapius.infrastructure.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;

    public List<ProductsDTO> findAllProducts(){
        return client.findAllProducts();
    }
}
