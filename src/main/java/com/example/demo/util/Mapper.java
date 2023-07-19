package com.example.demo.util;

import com.example.demo.dto.BrandDTO;
import com.example.demo.entity.Brand;

public class Mapper {
    public static Brand toEntity(BrandDTO dto){
        Brand brand = new Brand();
//        brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }
    public static BrandDTO brandDTO(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(brand.getName());
        return brandDTO;
    }


}
