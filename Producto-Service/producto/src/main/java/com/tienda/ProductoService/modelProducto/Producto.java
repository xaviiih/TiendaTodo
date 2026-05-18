package com.tienda.ProductoService.modelProducto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Producto")
public class Producto {

   @Id
   @Column(nullable=false)
   private Long id;

   @NotBlank(message="El nombre no puede estar vacío")
   @Column(nullable=false)
   private String nombre;

   @Min(value=1, message="El precio no puede ser menor a 1")
   @Column(nullable=false)
   private double precio;

   @Min(value=0, message="El stock no puede ser negativo")
   @Column(nullable=false)
   private int stock;

   public Long getId() { return id; }
   public void setId(Long id) { this.id = id; }
   public String getNombre() { return nombre; }
   public void setNombre(String nombre) { this.nombre = nombre; }
   public double getPrecio() { return precio; }
   public void setPrecio(double precio) { this.precio = precio; }
   public int getStock() { return stock; }
   public void setStock(int stock) { this.stock = stock; }
}