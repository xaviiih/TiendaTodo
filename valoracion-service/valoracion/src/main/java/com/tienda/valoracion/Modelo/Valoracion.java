package com.tienda.valoracion.Modelo;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="Valoracion")

public class Valoracion{
    @Id
    @Column(nullable=false)
    private int id_valoracion;
    @Column(nullable=false)
    private int id_producto;
    @Column(nullable=false)
    private int nro_cliente;
    @Column(nullable=false)
    private int estrellas;
    @Column(nullable=false)
    private LocalDate fecha_publicacion;

    public Valoracion(){}

    public Valoracion(int id_valoracion, int id_producto, int nro_cliente, int estrellas, LocalDate fecha_publicacion){
        this.id_valoracion=id_valoracion;
        this.id_producto=id_producto;
        this.nro_cliente=nro_cliente;
        this.estrellas=estrellas;
        this.fecha_publicacion=fecha_publicacion;
    }
    public int getId_valoracion(){
        return id_valoracion;
    }
    public int getId_producto(){
        return id_producto;
    }
    public int getNro_cliente(){
        return nro_cliente;
    }
    public int getEstrellas(){
        return estrellas;
    }
    public LocalDate getFecha_publicacion(){
        return fecha_publicacion;
    }
    public void setId_valoracion(int id_valoracion){
        this.id_valoracion=id_valoracion;
    }
    public void setId_producto(int id_producto){
        this.id_producto=id_producto;
    }
    public void setNro_cliente(int nro_cliente){
        this.nro_cliente=nro_cliente;
    }
    public void setEstrellas(int estrellas){
        this.estrellas=estrellas;
    }
    public void setFecha_publicacion(LocalDate fecha_publicacion){
        this.fecha_publicacion=fecha_publicacion;
    }


    
}
