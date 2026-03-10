package com.yprado.businesses.manager.controller;

import com.yprado.businesses.manager.dto.BusinessCreateDTO;
import com.yprado.businesses.manager.dto.BusinessDTO;
import com.yprado.businesses.manager.dto.BusinessUpdateDTO;
import com.yprado.businesses.manager.persistence.model.BusinessStatus;
import com.yprado.businesses.manager.service.BusinessService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/businesses")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity<BusinessDTO> create(@Valid @RequestBody BusinessCreateDTO createDTO) {
        var business = businessService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(business);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(businessService.findByIdOrThrow(id));
    }

    @GetMapping
    public ResponseEntity<List<BusinessDTO>> list() {
        return ResponseEntity.ok(businessService.listAll());
    }

    @PutMapping
    public ResponseEntity update(
            @Valid @RequestBody BusinessUpdateDTO updateDTO
    ) {
        businessService.update(updateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity changeStatus(
            @PathVariable String id,
            @Valid @RequestBody BusinessStatus status
    ) {
        businessService.changeStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        businessService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
