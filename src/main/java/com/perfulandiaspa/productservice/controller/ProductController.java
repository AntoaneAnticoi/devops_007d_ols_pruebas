package com.perfulandiaspa.productservice.controller;

import com.perfulandiaspa.productservice.model.Product;
import com.perfulandiaspa.productservice.service.ProductService;
import jakarta.validation.Valid; // Necesario para @Valid en la entidad
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("GET /api/products - Obteniendo todos los productos");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        logger.info("GET /api/products/{} - Buscando producto por ID", id);
        Optional<Product> product = productService.getProductById(id);

        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> {
                    logger.warn("Producto con ID {} no encontrado", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        // Nos aseguramos de que el ID sea nulo para que la DB lo genere
        logger.info("POST /api/products - Creando producto: {}", product.getName());
        product.setId(null); // Nos aseguramos que se genere nuevo ID
        Product newProduct = productService.addProduct(product);
        logger.info("Producto creado con ID {}", newProduct.getId());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @Valid @RequestBody Product productDetails) {
        logger.info("PUT /api/products/{} - Actualizando producto", id);

        return productService.updateProduct(id, productDetails)
                .map(product -> {
                    logger.info("Producto con ID {} actualizado exitosamente", id);
                    return new ResponseEntity<>(product, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    logger.warn("No se encontró producto con ID {} para actualizar", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        logger.info("DELETE /api/products/{} - Eliminando producto", id);
        if (productService.deleteProduct(id)) {
            logger.info("Producto con ID {} eliminado exitosamente", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found si no se encuentra
    }
}