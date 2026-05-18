package com.tienda.proveedorservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tienda.proveedorservice.model.Proveedor;
import com.tienda.proveedorservice.repository.ProveedorRepository;

@Service
public class ProveedorService {

   private static final Logger logger = LoggerFactory.getLogger(ProveedorService.class);

   @Autowired
   private ProveedorRepository repo;

   public List<Proveedor> listar() {
      logger.info("Obteniendo todos los proveedores");
      return repo.findAll();
   }

   public Proveedor guardar(Proveedor proveedor) {
      logger.info("Guardando proveedor: {}", proveedor.getNombre());
      return repo.save(proveedor);
   }

   public Proveedor obtener(Long id) {
      logger.info("Buscando proveedor con id: {}", id);
      Proveedor proveedor = repo.findById(id).orElse(null);
      if (proveedor == null) logger.warn("Proveedor {} no encontrado", id);
      return proveedor;
   }

   public void eliminar(Long id) {
      logger.info("Eliminando proveedor con id: {}", id);
      repo.deleteById(id);
      logger.info("Proveedor {} eliminado", id);
   }
}