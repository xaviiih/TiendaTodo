package com.tienda.proveedorservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Proveedor")
public class Proveedor {

   @Id
   @Column(nullable=false)
   private Long id;

   @NotBlank(message="El nombre no puede estar vacío")
   @Column(nullable=false)
   private String nombre;

   @NotBlank(message="La empresa no puede estar vacía")
   @Column(nullable=false)
   private String empresa;

   public Long getId() { return id; }
   public void setId(Long id) { this.id = id; }
   public String getNombre() { return nombre; }
   public void setNombre(String nombre) { this.nombre = nombre; }
   public String getEmpresa() { return empresa; }
   public void setEmpresa(String empresa) { this.empresa = empresa; }
}