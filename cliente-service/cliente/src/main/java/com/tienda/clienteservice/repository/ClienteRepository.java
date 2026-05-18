package com.tienda.clienteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.clienteservice.model.*;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}