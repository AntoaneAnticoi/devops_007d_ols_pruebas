package com.perfulandiaspa.productservice.service;

import com.perfulandiaspa.productservice.model.Product;
import com.perfulandiaspa.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

   
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        // El ID será generado automáticamente por la DB (GenerationType.UUID)
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(String id, Product productDetails) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            // Actualiza solo los campos que no sean nulos en productDetails (opcional, podrías actualizar todos)
            if (productDetails.getName() != null) existingProduct.setName(productDetails.getName());
            if (productDetails.getPrice() > 0) existingProduct.setPrice(productDetails.getPrice()); // Suponemos que 0 es un valor no deseado
            if (productDetails.getStock() >= 0) existingProduct.setStock(productDetails.getStock());
            if (productDetails.getDescription() != null) existingProduct.setDescription(productDetails.getDescription());

            return Optional.of(productRepository.save(existingProduct));
        }
        return Optional.empty(); // Retorna Optional.empty si no se encuentra
    }

    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}