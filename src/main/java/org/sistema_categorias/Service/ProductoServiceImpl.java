package org.sistema_categorias.Service;

import org.sistema_categorias.Dto.ProductoDto.ProductoRequestDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.sistema_categorias.Mapper.ProductoMapper;
import org.sistema_categorias.Model.Categoria;
import org.sistema_categorias.Model.Producto;
import org.sistema_categorias.Repository.CategoriaRepository;
import org.sistema_categorias.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Page<ProductoResponseDto> listaProductos(Pageable pageable) {

        Page<Producto> listaProductos = productoRepository.findAll(pageable);

        List<ProductoResponseDto> listaProductosDto = new ArrayList<>();

        for (Producto producto : listaProductos) {

            ProductoResponseDto productoResponseDto = productoMapper.productoToProductoResponseDto(producto);

            listaProductosDto.add(productoResponseDto);

        }
        return new PageImpl<>(listaProductosDto, pageable, listaProductos.getTotalElements());
    }


    @Override
    public ProductoResponseDto obtenerProducto(Long id) throws NotFoundException {

        Optional<Producto> productoEncontrado = productoRepository.findById(id);

        if (productoEncontrado.isPresent()) {

            return productoMapper.productoToProductoResponseDto(productoEncontrado.get());
        } else {

            throw new NotFoundException("Id del producto no encontrado:" + id);
        }


    }

    @Override
    public ProductoResponseDto crearProducto(ProductoRequestDto productoRequestDto) throws NotFoundException {

        Producto producto = productoMapper.productoRequestDtoToProducto(productoRequestDto);

        Optional<Categoria> categoria = categoriaRepository.findById(producto.getCategoria().getId());

        if (categoria.isPresent()) {

            producto.setCategoria(categoria.get());


            Producto productoGuardado = productoRepository.save(producto);

            return productoMapper.productoToProductoResponseDto(productoGuardado);

        } else {
            throw new NotFoundException("Id de la Categorí no encontrada:" + producto.getCategoria().getId());
        }


    }

    @Override
    public ProductoResponseDto editarProducto(Long id, ProductoRequestDto productoRequestDto) throws NotFoundException {

        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isPresent()) {
            Producto productoget = producto.get();

            productoget.setNombre(productoRequestDto.getNombre());
            productoget.setPrecio(productoRequestDto.getPrecio());
            productoget.setStock(productoRequestDto.getStock());

            Producto productoEditado = productoRepository.save(productoget);

            return productoMapper.productoToProductoResponseDto(productoEditado);
        } else {
            throw new NotFoundException("Id del producto no encontrado:" + id);
        }


    }

    @Override
    public void eliminarProducto(Long id) throws NotFoundException {

        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isPresent()) {
            productoRepository.deleteById(id);
        } else {
            throw new NotFoundException("Id del producto no encontrado:" + id);
        }
    }
}
