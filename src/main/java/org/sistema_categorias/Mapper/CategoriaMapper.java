package org.sistema_categorias.Mapper;

import org.mapstruct.Mapper;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaRequestDto;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseDto;
import org.sistema_categorias.Model.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria categoriaRequestDtoToCategoria(CategoriaRequestDto categoriaRequestDto);

    CategoriaResponseDto categoriaToCategoriaResponseDto(Categoria categoria);
}
