package com.example.candyshop.dto;

import com.example.candyshop.model.ProductoDto.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private String nombre;
    private Double precio;
    private Categoria categoria;
}
