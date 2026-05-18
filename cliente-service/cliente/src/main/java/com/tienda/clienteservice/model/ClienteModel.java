package com.tienda.clienteservice.model;


import jakarta.persistence.*;

@Entity
@Table(name="Cliente")
public class ClienteModel {

    @Id
    @Column(nullable=false)
    private Long id;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}