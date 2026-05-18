/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.envio.dto;

/**
 *
 * @author Arlettee
 */
public class EnvioResponseDTO {
    private int id_envio;
    private int id_carrito;
    private String direccion;
    private String estado;

    public EnvioResponseDTO() {
    }

    public EnvioResponseDTO(int id_envio, int id_carrito, String direccion, String estado) {
        this.id_envio = id_envio;
        this.id_carrito = id_carrito;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
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
