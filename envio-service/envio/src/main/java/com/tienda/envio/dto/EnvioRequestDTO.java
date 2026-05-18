/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.envio.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 *
 * @author Arlettee
 */
public class EnvioRequestDTO {
    @Min(value=1, message="La id no puede ser menor a 1")
    private int id_venta;
    @Min(value=1, message="La id del carrito no puede ser menor a 1")
    private int id_carrito;
    @NotBlank(message="La direccion no puede estar vacia")
    private String direccion;
    @NotBlank(message="El estado no puede estar vacio")
    private String estado;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
