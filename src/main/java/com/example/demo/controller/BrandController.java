package com.example.demo.controller;

import com.example.demo.dto.BrandDTO;
import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;
import com.example.demo.util.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     Brand brand = Mapper.toBrand(brandDTO);
     brand = brandService.createBrand(brand);
     return ResponseEntity.ok(Mapper.brandDTO(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findBrandById(@PathVariable("id") Integer brandId){
        Brand brand = brandService.findById(brandId);
        return ResponseEntity.ok(Mapper.brandDTO(brand));
    }

    @GetMapping("brand")
    public ResponseEntity<List<Brand>> getAllBrands(Brand brand){
        List<Brand> brands = brandService.getAllBrands(brand);
        return ResponseEntity.ok(brands);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id , @RequestBody BrandDTO brandDTO){
        Brand updateBrand = Mapper.toBrand(brandDTO);
        Brand updatedBrand = brandService.updateBrand(id, updateBrand);
        return ResponseEntity.ok(Mapper.brandDTO(updatedBrand));
    }
}
