package org.sistema_categorias.Service;

import org.sistema_categorias.Dto.ProductoDto.ProductoRequestDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {

    public Page<ProductoResponseDto> listaProductos(Pageable pageable);

    public ProductoResponseDto obtenerProducto(Long id) throws NotFoundException;

    public ProductoResponseDto crearProducto(ProductoRequestDto productoRequestDto) throws NotFoundException;

    public ProductoResponseDto editarProducto(Long id, ProductoRequestDto productoRequestDto) throws NotFoundException;

    public void eliminarProducto(Long id) throws NotFoundException;
}
