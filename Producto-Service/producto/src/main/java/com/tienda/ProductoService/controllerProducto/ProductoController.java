package com.tienda.ProductoService.controllerProducto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import com.tienda.ProductoService.modelProducto.Producto;
import com.tienda.ProductoService.serviceProducto.ProductoService;

@RestController
@RequestMapping("API/V1/productos")
public class ProductoController {

   private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

   @Autowired
   private ProductoService service;

   @GetMapping
   public ResponseEntity<List<Producto>> listar() {
      logger.info("GET /API/V1/productos");
      return ResponseEntity.ok(service.listar());
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> obtener(@PathVariable Long id) {
      logger.info("GET /API/V1/productos/{}", id);
      Producto producto = service.obtener(id);
      if (producto == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
      }
      return ResponseEntity.ok(producto);
   }

   @PostMapping
   public ResponseEntity<Producto> guardar(@Valid @RequestBody Producto producto) {
      logger.info("POST /API/V1/productos");
      return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(producto));
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
      logger.info("PUT /API/V1/productos/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
      }
      producto.setId(id);
      return ResponseEntity.ok(service.guardar(producto));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> eliminar(@PathVariable Long id) {
      logger.info("DELETE /API/V1/productos/{}", id);
      if (service.obtener(id) == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
      }
      service.eliminar(id);
      return ResponseEntity.ok("Producto eliminado correctamente");
   }
}