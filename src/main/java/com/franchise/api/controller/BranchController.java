package com.franchise.api.controller;

import com.franchise.api.dto.UpdateNameRequest;
import com.franchise.api.model.Branch;
import com.franchise.api.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises/{franchiseId}/branches")
@CrossOrigin
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public Branch addBranchToFranchise(@PathVariable Long franchiseId, @RequestBody Branch branch) {
        return branchService.addBranchToFranchise(franchiseId, branch);
    }

    @PutMapping("/{branchId}")
    public Branch updateBranchName(@PathVariable Long branchId, @RequestBody UpdateNameRequest request) {
        return branchService.updateBranchName(branchId, request.getName());
    }
}
