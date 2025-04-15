package org.sistema_categorias.Dto.ProductoDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.sistema_categorias.Dto.CategoriaDto.CategoriaResponseProductDto;
import org.sistema_categorias.Model.Categoria;

public class ProductoRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotNull(message = "El precio no puede estar vacío")
    private Double precio;
    @NotNull(message = "El stock no puede estar vacio")
    private Long stock;
    private CategoriaResponseProductDto categoria;

    public ProductoRequestDto() {
    }

    public ProductoRequestDto(String nombre, Double precio, Long stock, CategoriaResponseProductDto categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
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
