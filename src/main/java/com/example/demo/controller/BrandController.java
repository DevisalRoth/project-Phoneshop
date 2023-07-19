package com.example.demo.controller;

import com.example.demo.dto.BrandDTO;
import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;
import com.example.demo.util.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
     Brand brand = Mapper.toEntity(brandDTO);
     brand = brandService.createBrand(brand);
     return ResponseEntity.ok(Mapper.brandDTO(brand));
    }
}
