package com.perfulandiaspa.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min; // Importa las anotaciones de validación
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;

    @NotNull(message = "El precio del producto es requerido")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double price;

    @NotNull(message = "El stock del producto es requerido")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    private String description;
}