package com.tienda.ProductoService.serviceProducto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tienda.ProductoService.modelProducto.Producto;
import com.tienda.ProductoService.repositoryProducto.ProductoRepository;

@Service
public class ProductoService {

   private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

   @Autowired
   private ProductoRepository repo;

   public List<Producto> listar() {
      logger.info("Obteniendo todos los productos");
      return repo.findAll();
   }

   public Producto guardar(Producto producto) {
      logger.info("Guardando producto: {}", producto.getNombre());
      return repo.save(producto);
   }

   public Producto obtener(Long id) {
      logger.info("Buscando producto con id: {}", id);
      Producto producto = repo.findById(id).orElse(null);
      if (producto == null) logger.warn("Producto {} no encontrado", id);
      return producto;
   }

   public void eliminar(Long id) {
      logger.info("Eliminando producto con id: {}", id);
      repo.deleteById(id);
      logger.info("Producto {} eliminado", id);
   }
}