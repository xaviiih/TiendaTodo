
package com.tienda.carrito.Modelo;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="Carrito")

public class Carrito{
    @Id
    @Column(nullable=false)
    private int id_carrito;
    @Column(nullable=false)
    private int id_sucursal;
    @Column(nullable=false)
    private LocalDate fecha;
    @Column(nullable=false)
    private int id_empleado;
    @Column(nullable=false)
    private int nro_cliente;
    @Column(nullable=false)
    private int cant_productos;
    @Column(nullable=false)
    private double total;

    public Carrito(){}

    public Carrito(int id_carrito, int id_sucursal, LocalDate fecha, int id_empleado, int nro_cliente, int cant_productos, double total){
        this.id_carrito=id_carrito;
        this.id_sucursal=id_sucursal;
        this.fecha=fecha;
        this.id_empleado=id_empleado;
        this.nro_cliente=nro_cliente;
        this.cant_productos=cant_productos;
       this.total=total;}

    public void setId_carrito(int id_carrito){
        this.id_carrito=id_carrito;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    public void setId_sucursal(int id_sucursal){
        this.id_sucursal=id_sucursal;
    }

    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }

    public void setId_empleado(int id_empleado){
        this.id_empleado=id_empleado;
    }

    public void setNro_cliente(int nro_cliente){
        this.nro_cliente=nro_cliente;
    }

    public int getId_carrito(){
        return id_carrito;
    }
    public int getId_sucursal(){
        return id_sucursal;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public int getId_empleado(){
        return id_empleado;
    }
    public int getNro_cliente(){
        return nro_cliente;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    
    
}

