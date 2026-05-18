
package com.tienda.ProductoService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotBlank
    private String nombre;

    @Min(1)
    private int precio;

    private boolean disponible;

    @NotNull
    private Long proveedorId;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
}
