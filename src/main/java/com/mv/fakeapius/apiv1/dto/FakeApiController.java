package com.mv.fakeapius.apiv1.dto;

import com.mv.fakeapius.business.FakeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class FakeApiController {

    private final FakeApiService service;
}
