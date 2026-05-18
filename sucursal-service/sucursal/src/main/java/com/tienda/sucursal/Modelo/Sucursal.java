package com.tienda.sucursal.Modelo;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="Sucursal")

public class Sucursal{
    @Id
    @Column(nullable=false)
    private int id_sucursal;
    @Column(nullable=false)
    private String comuna;
    
   

    public Sucursal(){}

    public Sucursal(int id_sucursal, String comuna){
        this.id_sucursal=id_sucursal;
        this.comuna=comuna;
        }
    

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

   
    
}

