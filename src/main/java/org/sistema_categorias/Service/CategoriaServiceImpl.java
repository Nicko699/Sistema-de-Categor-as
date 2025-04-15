package org.sistema_categorias.Service;

import org.sistema_categorias.Dto.CategoriaDto.CategoriaRequestDto;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseDto;
import org.sistema_categorias.Exception.NotFoundException;
import org.sistema_categorias.Mapper.CategoriaMapper;
import org.sistema_categorias.Model.Categoria;
import org.sistema_categorias.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public Page<CategoriaResponseDto> listaCategorias(Pageable pageable) {

        Page<Categoria> listaCategorias = categoriaRepository.findAll(pageable);

        List<CategoriaResponseDto> listaCategoriasDto = new ArrayList<>();

        for (Categoria categoria : listaCategorias) {

            CategoriaResponseDto categoriaDto = categoriaMapper.categoriaToCategoriaResponseDto(categoria);

            listaCategoriasDto.add(categoriaDto);

        }

        return new PageImpl<>(listaCategoriasDto, pageable, listaCategorias.getTotalElements());
    }

    @Override
    public CategoriaResponseDto obtenerCategoria(Long id) throws NotFoundException {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {

            return categoriaMapper.categoriaToCategoriaResponseDto(categoria.get());
        } else {

            throw new NotFoundException("Id de la categoria no encontrado: " + id);
        }
    }

    @Override
    public CategoriaResponseDto crearCategoria(CategoriaRequestDto categoriaRequestDto) {

        Categoria categoria = categoriaMapper.categoriaRequestDtoToCategoria(categoriaRequestDto);

        Categoria categoriaGuardada = categoriaRepository.save(categoria);

        return categoriaMapper.categoriaToCategoriaResponseDto(categoriaGuardada);

    }

    @Override
    public CategoriaResponseDto editarCategoria(Long id, CategoriaRequestDto categoriaRequestDto) throws NotFoundException {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {

            categoria.get().setNombre(categoriaRequestDto.getNombre());
            categoria.get().setDescripcion(categoriaRequestDto.getDescripcion());

            Categoria categoriaGuardada = categoriaRepository.save(categoria.get());

            return categoriaMapper.categoriaToCategoriaResponseDto(categoriaGuardada);

        } else {

            throw new NotFoundException("Id de la categoria no encontrado:" + id);
        }


    }

    @Override
    public void eliminarCategoria(Long id) throws NotFoundException {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()){

            categoriaRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Id de la categoría no encontrado:" +id);
        }

    }
}
