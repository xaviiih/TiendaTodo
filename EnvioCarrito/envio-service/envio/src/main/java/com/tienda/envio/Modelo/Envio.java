package com.tienda.envio.Modelo;
import jakarta.persistence.*;

@Entity
@Table(name="Envio")

public class Envio{
    @Id
    @Column(nullable=false)
    private int id_envio;
    @Column(nullable=false)
    private int id_carrito;
    @Column(nullable=false)
    private String direccion;
    @Column(nullable=false)
    private String estado;

    public Envio(){}
    public Envio(int id_envio, int id_carrito, String direccion, String estado){
        this.id_envio=id_envio;
        this.id_carrito=id_carrito;
        this.direccion=direccion;
        this.estado=estado;
    }

    public int getId_envio(){
        return id_envio;
    }
    public int getId_carrito(){
        return id_carrito;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getEstado(){
        return estado;
    }

    public void setId_envio(int id_envio){
        this.id_envio=id_envio;
    }
    public void setId_carrito(int id_carrito){
        this.id_carrito=id_carrito;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }

}
