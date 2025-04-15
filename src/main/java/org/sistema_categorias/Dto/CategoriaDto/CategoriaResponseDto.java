package org.sistema_categorias.Dto.CategoriaDto;

import org.sistema_categorias.Dto.ProductoDto.ProductoResponseCategDto;
import org.sistema_categorias.Dto.ProductoDto.ProductoResponseDto;

import java.util.List;

public class CategoriaResponseDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<ProductoResponseCategDto> listaProductos;

    public CategoriaResponseDto() {
    }

    public CategoriaResponseDto(Long id, String nombre, String descripcion, List<ProductoResponseCategDto> listaProductos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaProductos = listaProductos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductoResponseCategDto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoResponseCategDto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
