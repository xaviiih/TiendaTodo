package com.tienda.ProductoService.repositoryProducto;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.ProductoService.modelProducto.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Long> {

}