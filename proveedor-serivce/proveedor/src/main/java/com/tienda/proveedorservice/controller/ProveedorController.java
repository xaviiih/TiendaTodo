package com.tienda.proveedorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.tienda.proveedorservice.model.Proveedor;
import com.tienda.proveedorservice.service.ProveedorService;

@RestController
@RequestMapping("API/V1/proveedores")
public class ProveedorController {

   private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

   @Autowired
   private ProveedorService service;

   @GetMapping
   public ResponseEntity<List<Proveedor>> listar() {
      logger.info("GET /API/V1/proveedores");
      return ResponseEntity.ok(service.listar());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> obtener(@PathVariable Long id) {
      logger.info("GET /API/V1/proveedores/{}", id);
      Proveedor proveedor = service.obtener(id);
      if (proveedor == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
      }
      return ResponseEntity.ok(proveedor);
   }

   @PostMapping
   public ResponseEntity<Proveedor> guardar(@Valid @RequestBody Proveedor proveedor) {
      logger.info("POST /API/V1/proveedores");
      return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(proveedor));
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Proveedor proveedor) {
      logger.info("PUT /API/V1/proveedores/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
      }
      proveedor.setId(id);
      return ResponseEntity.ok(service.guardar(proveedor));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> eliminar(@PathVariable Long id) {
      logger.info("DELETE /API/V1/proveedores/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
      }
      service.eliminar(id);
      return ResponseEntity.ok("Proveedor eliminado correctamente");
   }
}