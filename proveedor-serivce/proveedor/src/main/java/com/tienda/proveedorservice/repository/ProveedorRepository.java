package com.tienda.proveedorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.proveedorservice.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}