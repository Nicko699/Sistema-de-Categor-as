package org.sistema_categorias.Service;

import org.sistema_categorias.Dto.CategoriaDto.CategoriaRequestDto;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.sistema_categorias.Model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    public Page<CategoriaResponseDto> listaCategorias(Pageable pageable);

    public CategoriaResponseDto obtenerCategoria(Long id) throws NotFoundException;

    public CategoriaResponseDto crearCategoria(CategoriaRequestDto categoriaRequestDto);

    public CategoriaResponseDto editarCategoria(Long id, CategoriaRequestDto categoriaRequestDto) throws NotFoundException;

    public void eliminarCategoria(Long id) throws NotFoundException;



}
