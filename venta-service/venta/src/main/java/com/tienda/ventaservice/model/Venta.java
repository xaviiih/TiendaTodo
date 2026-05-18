
package com.tienda.ventaservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="venta")
public class Venta {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate fecha;
   private Long productoId;
   private String productoNombre;
   private Long clienteId;
   private String clienteNombre;
   private Long vendedorId;
   private String vendedorNombre;
   private int cantidad;
   private double total;

   public Long getId() { return id; }
   public void setId(Long id) { this.id = id; }
   public LocalDate getFecha() { return fecha; }
   public void setFecha(LocalDate fecha) { this.fecha = fecha; }
   public Long getProductoId() { return productoId; }
   public void setProductoId(Long productoId) { this.productoId = productoId; }
   public String getProductoNombre() { return productoNombre; }
   public void setProductoNombre(String productoNombre) { this.productoNombre = productoNombre; }
   public Long getClienteId() { return clienteId; }
   public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
   public String getClienteNombre() { return clienteNombre; }
   public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
   public Long getVendedorId() { return vendedorId; }
   public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }
   public String getVendedorNombre() { return vendedorNombre; }
   public void setVendedorNombre(String vendedorNombre) { this.vendedorNombre = vendedorNombre; }
   public int getCantidad() { return cantidad; }
   public void setCantidad(int cantidad) { this.cantidad = cantidad; }
   public double getTotal() { return total; }
   public void setTotal(double total) { this.total = total; }
}
