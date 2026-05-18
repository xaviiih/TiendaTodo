/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.envio.dto;

import java.time.LocalDate;

/**
 *
 * @author Arlettee
 */
public class VentaResponseDTO {
    private int id;
   private LocalDate fecha;
   private int id_carrito;
   private String estado;
   private double total;

    public VentaResponseDTO() {
    }

    public  VentaResponseDTO(int id_carrito, LocalDate fecha, int id, double total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado=estado;
        this.id_carrito = id_carrito;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
    
}
