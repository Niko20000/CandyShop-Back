package com.shop.candy.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@Table(name = "Clientes")
@Entity
public class Clientes extends Homosapience {

    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    public Clientes(String genero) {
        this.genero = genero;
    }

    public Clientes(String nombre, String apellido, String direccion, String genero) {
        super(nombre, apellido, direccion);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}