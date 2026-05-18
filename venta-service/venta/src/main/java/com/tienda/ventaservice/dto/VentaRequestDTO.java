
package com.tienda.ventaservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VentaRequestDTO {

    @NotNull
    private Long productoId;

    @NotNull
    private Long clienteId;

    @NotNull
    private Long vendedorId;

    @Min(1)
    private int cantidad;

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getVendedorId() { return vendedorId; }
    public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
