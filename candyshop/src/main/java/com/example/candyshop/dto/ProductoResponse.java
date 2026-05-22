package com.example.candyshop.dto;

import com.example.candyshop.model.ProductoDto.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {

    private Long id;
    private String nombre;
    private Double precio;
    private Categoria categoria;
    private LocalDateTime fechaCreacion;
}
