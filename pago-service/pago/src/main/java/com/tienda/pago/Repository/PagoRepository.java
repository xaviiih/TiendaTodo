package com.tienda.pago.Repository;
import com.tienda.pago.Modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer>{
    
}
