package org.sistema_categorias.Dto.CategoriaDto;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaRequestDto {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotEmpty(message = "La descripcion no puede estar vacía")
    private String descripcion;

    public CategoriaRequestDto() {
    }

    public CategoriaRequestDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
