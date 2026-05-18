/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.carrito.dto;

import java.time.LocalDate;

/**
 *
 * @author Arlettee
 */
public class CarritoResponseDTO {
    private int id_carrito;
    private LocalDate fecha;
    private int cant_productos;
    private double total;

    public CarritoResponseDTO() {
    }

    public CarritoResponseDTO(int id_carrito, LocalDate fecha, int cant_productos, double total) {
        this.id_carrito = id_carrito;
        this.fecha = fecha;
        this.cant_productos = cant_productos;
        this.total = total;
    }

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
