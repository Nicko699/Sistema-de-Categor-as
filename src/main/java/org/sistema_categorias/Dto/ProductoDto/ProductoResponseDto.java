package org.sistema_categorias.Dto.ProductoDto;

import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseDto;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseProductDto;

public class ProductoResponseDto {

    private Long id;
    private String nombre;
    private Double precio;
    private Long stock;
    private CategoriaResponseProductDto categoria;

    public ProductoResponseDto() {
    }

    public ProductoResponseDto(Long id, String nombre, Double precio, Long stock, CategoriaResponseProductDto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public CategoriaResponseProductDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseProductDto categoria) {
        this.categoria = categoria;
    }
}
