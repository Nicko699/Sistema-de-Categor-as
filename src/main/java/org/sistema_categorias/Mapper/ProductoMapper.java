package org.sistema_categorias.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema_categorias.Dto.ProductoDto.ProductoRequestDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseCategDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseDto;
import org.sistema_categorias.Model.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

   @Mapping(source = "categoria", target = "categoria")
    Producto productoRequestDtoToProducto(ProductoRequestDto productoRequestDto);

    ProductoResponseDto productoToProductoResponseDto(Producto producto);

}
