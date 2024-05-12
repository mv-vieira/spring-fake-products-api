package com.mv.fakeapius.apiv1.dto;

import com.mv.fakeapius.business.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class FakeApiController {

    private final FakeApiService service;

    @Operation(summary = "Buscar todos os produtos", method = "GET")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Search completed successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid request data"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Error when performing data search")
    })
    @GetMapping
    public ResponseEntity<List<ProductsDTO>> findAllProducts(){
        return ResponseEntity.ok(service.findAllProducts());
    }
}
