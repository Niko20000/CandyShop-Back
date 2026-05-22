package com.example.candyshop.controller;

import com.example.candyshop.dto.ProductoRequest;
import com.example.candyshop.dto.ProductoResponse;
import com.example.candyshop.model.ProductoDto.Categoria;
import com.example.candyshop.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dulces")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoResponse>> listarPorCategoria(
            @PathVariable Categoria categoria) {
        return ResponseEntity.ok(service.listarPorCategoria(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtener(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crear(
            @RequestBody ProductoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizar(
            @PathVariable Long id,
            @RequestBody ProductoRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
