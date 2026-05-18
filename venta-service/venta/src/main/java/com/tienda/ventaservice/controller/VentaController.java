package com.tienda.ventaservice.controller;

import com.tienda.ventaservice.dto.VentaRequestDTO;
import com.tienda.ventaservice.model.Venta;
import com.tienda.ventaservice.service.VentaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/API/V1/ventas")
public class VentaController {

   private static final Logger logger = LoggerFactory.getLogger(VentaController.class);

   private final VentaService service;

   public VentaController(VentaService service) {
      this.service = service;
   }

   @GetMapping
   public ResponseEntity<List<Venta>> listar() {
      logger.info("GET /API/V1/ventas");
      return ResponseEntity.ok(service.listar());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> obtener(@PathVariable Long id) {
      logger.info("GET /API/V1/ventas/{}", id);
      Venta venta = service.obtener(id);
      if (venta == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");
      }
      return ResponseEntity.ok(venta);
   }

   @PostMapping
   public ResponseEntity<?> guardar(@Valid @RequestBody VentaRequestDTO venta) {
      logger.info("POST /API/V1/ventas");
      try {
         return ResponseEntity.status(HttpStatus.CREATED).body(service.crearVenta(venta));
      } catch (RuntimeException e) {
         logger.error("Error al crear venta: {}", e.getMessage());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> eliminar(@PathVariable Long id) {
      logger.info("DELETE /API/V1/ventas/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");
      }
      service.eliminar(id);
      return ResponseEntity.ok("Venta eliminada correctamente");
   }
}