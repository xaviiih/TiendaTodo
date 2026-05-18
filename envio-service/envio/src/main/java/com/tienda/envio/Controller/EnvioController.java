package com.tienda.envio.Controller;

import com.tienda.envio.dto.EnvioRequestDTO;
import com.tienda.envio.Modelo.Envio;
import com.tienda.envio.Service.EnvioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/API/V1/envios")
public class EnvioController {

    private static final Logger logger = LoggerFactory.getLogger(EnvioController.class);

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public ResponseEntity<List<Envio>> listar() {
        logger.info("GET /API/V1/envios");
        return ResponseEntity.ok(envioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        logger.info("GET /API/V1/envios/{}", id);
        Envio envio = envioService.findById(id);
        if (envio == null) {
            logger.warn("Envio {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envio no encontrado");
        }
        return ResponseEntity.ok(envio);
    }

    @PostMapping
    public ResponseEntity<?> crearEnvio(@Valid @RequestBody EnvioRequestDTO dto) {
        logger.info("POST /API/V1/envios");
        try {
            Envio envio = envioService.crearEnvio(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(envio);
        } catch (RuntimeException e) {
            logger.error("Error al crear envio: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        logger.info("DELETE /API/V1/envios/{}", id);
        Envio envio = envioService.findById(id);
        if (envio == null) {
            logger.warn("Envio {} no encontrado para eliminar", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envio no encontrado");
        }
        envioService.eliminar(id);
        return ResponseEntity.ok("Envio eliminado correctamente");
    }
}