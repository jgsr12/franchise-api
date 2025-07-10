package com.franchise.api.service;

import com.franchise.api.model.Franchise;
import com.franchise.api.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    public Optional<Franchise> getFranchiseById(Long id) {
        return franchiseRepository.findById(id);
    }

    public Franchise updateFranchiseName(Long id, String newName) {
        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franchise.setName(newName);
        return franchiseRepository.save(franchise);
    }
}
