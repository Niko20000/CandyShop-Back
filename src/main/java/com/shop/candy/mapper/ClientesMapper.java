package com.shop.candy.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shop.candy.dto.ClientesRequestDTO;
import com.shop.candy.dto.ClientesResponseDTO;
import com.shop.candy.models.Clientes;

// --- DE ENTIDAD A DTO (Para responderle al cliente) ---
@Mapper(componentModel = "spring")
public interface ClientesMapper {

    @Mapping(target = "genero", source = "genero")
    List<ClientesResponseDTO> toResponseDTOList(List<Clientes> clientes);

    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "genero", source = "genero")

    Clientes toEntity(ClientesRequestDTO requestDTO);

}
