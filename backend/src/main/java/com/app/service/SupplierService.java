package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Supplier;

public interface SupplierService {

    List<Supplier> findAll();

    Optional<Supplier> findById(Long id);

    Supplier save(Supplier supplier);

    void delete(Supplier supplier);
}
