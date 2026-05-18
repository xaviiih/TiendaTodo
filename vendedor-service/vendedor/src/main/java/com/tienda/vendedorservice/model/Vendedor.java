package com.tienda.vendedorservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Vendedor")
public class Vendedor {

   @Id
   @Column(nullable=false)
   private Long id;

   @NotBlank(message="El nombre no puede estar vacío")
   @Column(nullable=false)
   private String nombre;

   @NotBlank(message="El teléfono no puede estar vacío")
   @Column(nullable=false)
   private String telefono;

   public Long getId() { return id; }
   public void setId(Long id) { this.id = id; }
   public String getNombre() { return nombre; }
   public void setNombre(String nombre) { this.nombre = nombre; }
   public String getTelefono() { return telefono; }
   public void setTelefono(String telefono) { this.telefono = telefono; }
}