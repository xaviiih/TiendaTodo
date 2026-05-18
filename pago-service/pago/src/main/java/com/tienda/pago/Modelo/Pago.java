package com.tienda.pago.Modelo;
import jakarta.persistence.*;

@Entity
@Table(name="Pago")

public class Pago{
    @Id
    @Column(nullable=false)
    private int id_pago;
    @Column(nullable=false)
    private String metodo_pago;
    @Column(nullable=false)
    private int nro_cliente;
    @Column(nullable=false)
    private int id_pedido;

    public Pago() {
    }

    public Pago(int id_pago, String metodo_pago, int nro_cliente, int id_pedido) {
        this.id_pago = id_pago;
        this.metodo_pago = metodo_pago;
        this.nro_cliente = nro_cliente;
        this.id_pedido = id_pedido;
    }


    public int getId_pago(){
        return id_pago;
    }
    public String getMetodo_pago(){
        return metodo_pago;
    }
    public int getNro_cliente(){
        return nro_cliente;
    }
    public int getId_pedido(){
        return id_pedido;
    }
    public void setId_pago(int id_pago){
        this.id_pago=id_pago;
    }
    public void setMetodo_pago(String metodo_pago){
        this.metodo_pago=metodo_pago;
    }
    public void setNro_cliente(int nro_cliente){
        this.nro_cliente=nro_cliente;
    }
    public void setId_pedido(int id_pedido){
        this.id_pedido=id_pedido;
    }
}
