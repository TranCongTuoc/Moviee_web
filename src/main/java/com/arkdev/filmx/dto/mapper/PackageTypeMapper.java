package com.arkdev.filmx.dto.mapper;

import com.arkdev.filmx.dto.mapper.is.IPackageTypeMapper;
import com.arkdev.filmx.dto.request.PackageTypeRequest;
import com.arkdev.filmx.model.PackageType;
import org.springframework.stereotype.Component;

@Component
public class PackageTypeMapper implements IPackageTypeMapper {

    @Override
    public PackageType toPackageType(PackageTypeRequest request) {
        if (request == null) {
            return null;
        } else {
            PackageType.PackageTypeBuilder builder = PackageType.builder();
            builder.packageName(request.packageName());
            builder.description(request.description());
            builder.price(request.price());
            builder.duration(request.duration());
            return builder.build();
        }
    }

    @Override
    public void updatePackageType(PackageType packageType, PackageTypeRequest request) {
        if (request != null) {
            packageType.setPackageName(request.packageName());
            packageType.setDescription(request.description());
            packageType.setPrice(request.price());
            packageType.setDuration(request.duration());
        }
    }
}
