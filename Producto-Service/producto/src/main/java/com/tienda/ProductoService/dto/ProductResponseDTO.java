
package com.tienda.ProductoService.dto;

public class ProductResponseDTO {

    private Long id;
    private String nombre;
    private int precio;
    private boolean disponible;
    private Long proveedorId;

    public ProductResponseDTO() {}

    public ProductResponseDTO(Long id, String nombre, int precio, boolean disponible, Long proveedorId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.proveedorId = proveedorId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
}
