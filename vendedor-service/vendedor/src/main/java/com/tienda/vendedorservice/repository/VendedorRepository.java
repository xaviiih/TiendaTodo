package com.tienda.vendedorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.vendedorservice.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}



