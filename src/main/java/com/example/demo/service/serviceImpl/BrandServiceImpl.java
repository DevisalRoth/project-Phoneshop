package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Brand;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {

        return brandRepository.save(brand);
    }


    //    It's not the best practice.
    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(()-> new ApiException(HttpStatus.NOT_FOUND , String.format("Brand id = %d Is not found" ,id)));

    }

    @Override
    public List<Brand> getAllBrands(Brand brand) {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Integer id, Brand brandUpdate) {
          Brand brand= findById(id);
           brand.setName(brand.getName());
        return brandRepository.save(brand);
    }
}
