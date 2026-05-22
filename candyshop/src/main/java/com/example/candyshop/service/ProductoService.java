package com.example.candyshop.service;

import com.example.candyshop.dto.ProductoRequest;
import com.example.candyshop.dto.ProductoResponse;
import com.example.candyshop.mapper.ProductoMapper;
import com.example.candyshop.model.ProductoDto;
import com.example.candyshop.model.ProductoDto.Categoria;
import com.example.candyshop.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public List<ProductoResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(producto -> mapper.toResponse(producto))
                .toList();
    }

    public List<ProductoResponse> listarPorCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria)
                .stream()
                .map(producto -> mapper.toResponse(producto))
                .toList();
    }

    public ProductoResponse obtenerPorId(Long id) {
        ProductoDto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Producto no encontrado con id: " + id));
        return mapper.toResponse(producto);
    }

    public ProductoResponse crear(ProductoRequest request) {
        ProductoDto producto = mapper.toEntity(request);
        return mapper.toResponse(repository.save(producto));
    }

    public ProductoResponse actualizar(Long id, ProductoRequest request) {
        ProductoDto existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Producto no encontrado con id: " + id));
        mapper.updateEntity(request, existente);
        return mapper.toResponse(repository.save(existente));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
