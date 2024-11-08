package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.mapper.is.IPackageTypeMapper;
import com.arkdev.filmx.dto.request.PackageTypeRequest;
import com.arkdev.filmx.model.PackageType;
import com.arkdev.filmx.repository.PackageTypeRepository;
import com.arkdev.filmx.service.is.IPackageTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PackageTypeService implements IPackageTypeService {
    PackageTypeRepository packageTypeRepository;
    IPackageTypeMapper packageTypeMapper;

    @Override
    public void insertPackageType(PackageTypeRequest request) {
        PackageType packageType = packageTypeMapper.toPackageType(request);
        packageTypeRepository.save(packageType);
        log.info("Insert package type: {}", packageType);
    }

    @Override
    public void updatePackageType(Integer packageId, PackageTypeRequest request) {
        PackageType packageType = packageTypeRepository.findById(packageId).orElseThrow(
                () -> new IllegalArgumentException("Package id " + packageId + " not found")
        );
        packageTypeMapper.updatePackageType(packageType, request);
        log.info("Update package type: {}", packageType);
    }

    @Override
    public void deletePackageType(Integer packageId) {
        packageTypeRepository.deleteById(packageId);
    }

    @Override
    public List<PackageType> getAllPackageTypes() {
        return packageTypeRepository.findAll();
    }

    @Override
    public PackageType getPackageTypeById(Integer packageId) {
        return packageTypeRepository.findById(packageId).orElseThrow(
                () -> new IllegalArgumentException("Package id " + packageId + " not found")
        );
    }
}
