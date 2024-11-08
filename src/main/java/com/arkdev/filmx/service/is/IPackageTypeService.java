package com.arkdev.filmx.service.is;

import com.arkdev.filmx.dto.request.PackageTypeRequest;
import com.arkdev.filmx.model.PackageType;

import java.util.List;

public interface IPackageTypeService {
    void insertPackageType(PackageTypeRequest request);

    void updatePackageType(Integer packageId, PackageTypeRequest request);

    void deletePackageType(Integer packageId);

    List<PackageType> getAllPackageTypes();

    PackageType getPackageTypeById(Integer packageId);
}
