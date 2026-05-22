package com.example.candyshop.repository;

import com.example.candyshop.model.ProductoDto;
import com.example.candyshop.model.ProductoDto.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, Long> {

    List<ProductoDto> findByCategoria(Categoria categoria);
}
