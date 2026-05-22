package com.shop.candy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.candy.models.Clientes;


@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    List<Clientes> findByNombre(String nombre);

    List<Clientes> findById(int id);

}
