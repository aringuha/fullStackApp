package com.app.controller;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Supplier;
import com.app.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.findAll();

        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable Long id) {
    	Supplier supplier = supplierService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id: " + id));

        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> createSupplier(@RequestBody @Valid Supplier supplier, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
        	Supplier savedSupplier = supplierService.save(supplier);

            return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(
            @PathVariable Long id,
            @RequestBody @Valid Supplier supplierDetails,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
        	Supplier supplier = supplierService.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id: " + id));

        	supplier.setFirstName(supplierDetails.getFirstName());
        	supplier.setLastName(supplierDetails.getLastName());
        	supplier.setCity(supplierDetails.getCity());
        	supplier.setAddress(supplierDetails.getAddress());
        	supplier.setTelephone(supplierDetails.getTelephone());

        	supplierService.save(supplier);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id) {
    	Supplier supplier = supplierService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not exist with id: " + id));

    	supplierService.delete(supplier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
//        return ResponseEntity.ok(response);
    }
}
