package com.tienda.carrito.Controller;

import com.tienda.carrito.dto.CarritoResponseDTO;
import com.tienda.carrito.dto.CarritoRequestDTO;
import com.tienda.carrito.Service.CarritoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/API/V1/carritos")
public class CarritoController {

    private static final Logger logger = LoggerFactory.getLogger(CarritoController.class);

    @Autowired
    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public ResponseEntity<List<CarritoResponseDTO>> getTodas() {
        logger.info("GET /API/V1/carritos");
        return ResponseEntity.ok(carritoService.getTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        logger.info("GET /API/V1/carritos/{}", id);
        CarritoResponseDTO carrito = carritoService.findById(id);
        if (carrito == null) {
            logger.warn("Carrito {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");
        }
        return ResponseEntity.ok(carrito);
    }

    @PostMapping
    public ResponseEntity<CarritoResponseDTO> guardar(@Valid @RequestBody CarritoRequestDTO dto) {
        logger.info("POST /API/V1/carritos");
        CarritoResponseDTO creado = carritoService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @Valid @RequestBody CarritoRequestDTO dto) {
        logger.info("PUT /API/V1/carritos/{}", id);
        CarritoResponseDTO existente = carritoService.findById(id);
        if (existente == null) {
            logger.warn("Carrito {} no encontrado para actualizar", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");
        }
        dto.setId_carrito(id);
        CarritoResponseDTO actualizado = carritoService.guardar(dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        logger.info("DELETE /API/V1/carritos/{}", id);
        CarritoResponseDTO existente = carritoService.findById(id);
        if (existente == null) {
            logger.warn("Carrito {} no encontrado para eliminar", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");
        }
        carritoService.eliminar(id);
        return ResponseEntity.ok("Carrito eliminado correctamente");
    }
}