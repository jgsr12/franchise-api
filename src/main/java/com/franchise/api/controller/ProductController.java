package com.franchise.api.controller;

import com.franchise.api.dto.UpdateNameRequest;
import com.franchise.api.dto.UpdateStockRequest;
import com.franchise.api.model.Product;
import com.franchise.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/branches/{branchId}/products")
    public Product addProductToBranch(@PathVariable Long branchId, @RequestBody Product product) {
        return productService.addProductToBranch(branchId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/products/{productId}/stock")
    public Product updateStock(@PathVariable Long productId, @RequestBody UpdateStockRequest request) {
        return productService.updateProductStock(productId, request.getStock());
    }

    @PutMapping("/products/{productId}/name")
    public Product updateProductName(@PathVariable Long productId, @RequestBody UpdateNameRequest request) {
        return productService.updateProductName(productId, request.getName());
    }

    @GetMapping("/branches/{branchId}/highest-stock")
    public Product getHighestStockProduct(@PathVariable Long branchId) {
        return productService.getHighestStockProductByBranch(branchId);
    }
}
