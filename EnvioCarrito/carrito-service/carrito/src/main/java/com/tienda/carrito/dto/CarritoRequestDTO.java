/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.carrito.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
/**
 *
 * @author Arlettee
 */
public class CarritoRequestDTO {
   
    @Min(value=1,message="El identificador no puede ser menor que uno")
    private int id_carrito;
    
    @PastOrPresent(message="La fecha no puede ser en el futuro")
    private LocalDate fecha;
    
    @Min(value=1,message="La cantidad de productos no puede ser menor a 1")
    private int cant_productos;
    
    @Min(value=1,message="El precio no puede ser menor a 1")
    private double total;

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
