package com.example.candyshop;

import com.example.candyshop.dto.ProductoRequest;
import com.example.candyshop.dto.ProductoResponse;
import com.example.candyshop.model.ProductoDto.Categoria;
import com.example.candyshop.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CandyshopApplication implements CommandLineRunner {

    private final ProductoService service;

    public static void main(String[] args) {
        SpringApplication.run(CandyshopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("=== SIMULACIÓN CANDYSHOP ===");

        ProductoResponse p1 = service.crear(
                new ProductoRequest("Chocolatina", 1500.0, Categoria.CHOCOLATE));
        ProductoResponse p2 = service.crear(
                new ProductoRequest("Gomitas de fresa", 800.0, Categoria.GOMITAS));

        System.out.println("✅ Creado: " + p1);
        System.out.println("✅ Creado: " + p2);

        System.out.println("\n📋 Todos:");
        service.listarTodos().forEach(System.out::println);

        System.out.println("\n🔍 Buscar id 1: " + service.obtenerPorId(1L));

        service.actualizar(1L,
                new ProductoRequest("Chocolatina Premium", 2000.0, Categoria.CHOCOLATE));
        System.out.println("\n✏️ Actualizado: " + service.obtenerPorId(1L));

        service.eliminar(2L);
        System.out.println("\n🗑️ Eliminado id 2");

        System.out.println("\n📋 Lista final:");
        service.listarTodos().forEach(System.out::println);

        System.out.println("\n=== FIN SIMULACIÓN ===");
    }
}
