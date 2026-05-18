package com.tienda.vendedorservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tienda.vendedorservice.model.Vendedor;
import com.tienda.vendedorservice.repository.VendedorRepository;

@Service
public class VendedorService {

   private static final Logger logger = LoggerFactory.getLogger(VendedorService.class);

   @Autowired
   private VendedorRepository repo;

   public List<Vendedor> listar() {
      logger.info("Obteniendo todos los vendedores");
      return repo.findAll();
   }

   public Vendedor guardar(Vendedor vendedor) {
      logger.info("Guardando vendedor: {}", vendedor.getNombre());
      return repo.save(vendedor);
   }

   public Vendedor obtener(Long id) {
      logger.info("Buscando vendedor con id: {}", id);
      Vendedor vendedor = repo.findById(id).orElse(null);
      if (vendedor == null) logger.warn("Vendedor {} no encontrado", id);
      return vendedor;
   }

   public void eliminar(Long id) {
      logger.info("Eliminando vendedor con id: {}", id);
      repo.deleteById(id);
      logger.info("Vendedor {} eliminado", id);
   }
}