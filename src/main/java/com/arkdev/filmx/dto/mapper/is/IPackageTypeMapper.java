package com.arkdev.filmx.dto.mapper.is;

import com.arkdev.filmx.dto.request.PackageTypeRequest;
import com.arkdev.filmx.model.PackageType;

public interface IPackageTypeMapper {
    PackageType toPackageType(PackageTypeRequest request);

    void updatePackageType(PackageType packageType, PackageTypeRequest request);
}
