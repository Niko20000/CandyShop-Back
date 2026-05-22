package com.example.candyshop.mapper;

import com.example.candyshop.dto.ProductoRequest;
import com.example.candyshop.dto.ProductoResponse;
import com.example.candyshop.model.ProductoDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto toEntity(ProductoRequest request);

    ProductoResponse toResponse(ProductoDto producto);

    void updateEntity(ProductoRequest request, @MappingTarget ProductoDto producto);
}
