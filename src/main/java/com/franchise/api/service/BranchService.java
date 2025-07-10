package com.franchise.api.service;

import com.franchise.api.model.Branch;
import com.franchise.api.model.Franchise;
import com.franchise.api.repository.BranchRepository;
import com.franchise.api.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private FranchiseRepository franchiseRepository;

    public Branch addBranchToFranchise(Long franchiseId, Branch branch) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        branch.setFranchise(franchise);
        return branchRepository.save(branch);
    }

    public Branch updateBranchName(Long branchId, String newName) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        branch.setName(newName);
        return branchRepository.save(branch);
    }
}
