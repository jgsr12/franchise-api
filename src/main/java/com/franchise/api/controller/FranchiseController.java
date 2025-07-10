package com.franchise.api.controller;

import com.franchise.api.dto.UpdateNameRequest;
import com.franchise.api.model.Franchise;
import com.franchise.api.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
@CrossOrigin
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.createFranchise(franchise);
    }

    @GetMapping
    public List<Franchise> getAllFranchises() {
        return franchiseService.getAllFranchises();
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable Long id) {
        return franchiseService.getFranchiseById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
    }

    @PutMapping("/{id}")
    public Franchise updateFranchiseName(@PathVariable Long id, @RequestBody UpdateNameRequest request) {
        return franchiseService.updateFranchiseName(id, request.getName());
    }
}
