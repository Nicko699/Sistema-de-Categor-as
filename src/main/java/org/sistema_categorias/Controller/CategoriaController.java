package org.sistema_categorias.Controller;

import jakarta.validation.Valid;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaRequestDto;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.sistema_categorias.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Page<CategoriaResponseDto>> listaCategorias(Pageable pageable) {

        Page<CategoriaResponseDto> listaCategoria = categoriaService.listaCategorias(pageable);

        return ResponseEntity.ok(listaCategoria);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> obtenerCategoria(@PathVariable Long id) throws NotFoundException {

        CategoriaResponseDto categoriaResponseDto = categoriaService.obtenerCategoria(id);

        return ResponseEntity.ok(categoriaResponseDto);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> crearCategoria(@Valid @RequestBody CategoriaRequestDto categoriaRequestDto) {

        CategoriaResponseDto categoriaResponseDto = categoriaService.crearCategoria(categoriaRequestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(categoriaResponseDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(categoriaResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> editarCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDto categoriaRequestDto) throws NotFoundException {

        categoriaService.editarCategoria(id, categoriaRequestDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> eliminarCategoria(@PathVariable Long id) throws NotFoundException {

        categoriaService.eliminarCategoria(id);

        return ResponseEntity.noContent().build();
    }
}
