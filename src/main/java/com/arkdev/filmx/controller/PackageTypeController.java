package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.PackageTypeRequest;
import com.arkdev.filmx.model.PackageType;
import com.arkdev.filmx.service.is.IPackageTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PackageTypeController {
    IPackageTypeService packageTypeService;

    @GetMapping("/view")
    public ResponseEntity<?> getAllPackageTypes() {
        List<PackageType> packageTypes = packageTypeService.getAllPackageTypes();
        return ResponseEntity.ok(packageTypes);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPackageType(@RequestBody @Validated PackageTypeRequest request) {
        packageTypeService.insertPackageType(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePackageType(@RequestParam Integer packageId, @RequestBody @Validated PackageTypeRequest request) {
        packageTypeService.updatePackageType(packageId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deletePackageType(@RequestParam Integer packageId) {
        packageTypeService.deletePackageType(packageId);
        return ResponseEntity.ok().build();
    }
}
