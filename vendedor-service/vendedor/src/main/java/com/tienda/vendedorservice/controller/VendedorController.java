package com.tienda.vendedorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.tienda.vendedorservice.model.Vendedor;
import com.tienda.vendedorservice.service.VendedorService;

@RestController
@RequestMapping("API/V1/vendedores")
public class VendedorController {

   private static final Logger logger = LoggerFactory.getLogger(VendedorController.class);

   @Autowired
   private VendedorService service;

   @GetMapping
   public ResponseEntity<List<Vendedor>> listar() {
      logger.info("GET /API/V1/vendedores");
      return ResponseEntity.ok(service.listar());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> obtener(@PathVariable Long id) {
      logger.info("GET /API/V1/vendedores/{}", id);
      Vendedor vendedor = service.obtener(id);
      if (vendedor == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor no encontrado");
      }
      return ResponseEntity.ok(vendedor);
   }

   @PostMapping
   public ResponseEntity<Vendedor> guardar(@Valid @RequestBody Vendedor vendedor) {
      logger.info("POST /API/V1/vendedores");
      return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(vendedor));
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Vendedor vendedor) {
      logger.info("PUT /API/V1/vendedores/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor no encontrado");
      }
      vendedor.setId(id);
      return ResponseEntity.ok(service.guardar(vendedor));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> eliminar(@PathVariable Long id) {
      logger.info("DELETE /API/V1/vendedores/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor no encontrado");
      }
      service.eliminar(id);
      return ResponseEntity.ok("Vendedor eliminado correctamente");
   }
}