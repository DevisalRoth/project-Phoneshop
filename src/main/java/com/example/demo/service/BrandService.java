package com.example.demo.service;

import com.example.demo.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);
    Brand findById(Integer id);
    List<Brand> getAllBrands(Brand brand);
    Brand updateBrand(Integer id, Brand brandUpdate);
}
