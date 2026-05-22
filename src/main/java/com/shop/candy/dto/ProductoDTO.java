
package com.shop.candy.dto;

public class ProductoDTO {
    private String nombre;
    private double precio;

    public ProductoDTO(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}