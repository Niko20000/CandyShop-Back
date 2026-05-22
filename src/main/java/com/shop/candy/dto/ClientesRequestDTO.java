package com.shop.candy.dto;

import lombok.Data;

@Data
public class ClientesRequestDTO {
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;
}
