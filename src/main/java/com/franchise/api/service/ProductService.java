package com.franchise.api.service;

import com.franchise.api.model.Branch;
import com.franchise.api.model.Product;
import com.franchise.api.repository.BranchRepository;
import com.franchise.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchRepository branchRepository;

    public Product addProductToBranch(Long branchId, Product product) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        product.setBranch(branch);
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProductStock(Long productId, int newStock) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setStock(newStock);
        return productRepository.save(product);
    }

    public List<Product> getProductsByBranch(Long branchId) {
        return productRepository.findByBranchId(branchId);
    }

    public Product getHighestStockProductByBranch(Long branchId) {
        return productRepository.findByBranchId(branchId).stream()
                .max(Comparator.comparingInt(Product::getStock))
                .orElseThrow(() -> new RuntimeException("No hay productos en esta sucursal"));
    }

    public Product updateProductName(Long productId, String newName) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setName(newName);
        return productRepository.save(product);
    }
}
