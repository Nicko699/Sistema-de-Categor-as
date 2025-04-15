package org.sistema_categorias.Controller;

import jakarta.validation.Valid;
import org.sistema_categorias.Dto.ProductoDto.ProductoRequestDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.sistema_categorias.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Page<ProductoResponseDto>> listaProductos(Pageable pageable) {

        Page<ProductoResponseDto> listaProducto = productoService.listaProductos(pageable);

        return ResponseEntity.ok(listaProducto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> obtenerProducto(@PathVariable Long id) throws NotFoundException {


        ProductoResponseDto productoResponseDto = productoService.obtenerProducto(id);

        return ResponseEntity.ok(productoResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDto> crearProducto(@Valid @RequestBody ProductoRequestDto productoRequestDto) throws NotFoundException {

        ProductoResponseDto productoResponseDto = productoService.crearProducto(productoRequestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productoResponseDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(productoResponseDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> editarProducto(@PathVariable Long id, @Valid @RequestBody ProductoRequestDto productoRequestDto) throws NotFoundException {

        productoService.editarProducto(id, productoRequestDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> eliminarProducto(@PathVariable Long id) throws NotFoundException {

        productoService.eliminarProducto(id);

        return ResponseEntity.noContent().build();
    }


}
