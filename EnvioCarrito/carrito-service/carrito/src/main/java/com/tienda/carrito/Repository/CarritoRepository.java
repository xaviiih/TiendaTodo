package com.tienda.carrito.Repository;
import com.tienda.carrito.Modelo.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Arlettee
 */
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
    
}
