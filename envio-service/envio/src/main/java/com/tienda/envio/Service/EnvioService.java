package com.tienda.envio.Service;

import com.tienda.envio.Client.VentaClient;
import com.tienda.envio.dto.EnvioRequestDTO;
import com.tienda.envio.dto.VentaResponseDTO;
import com.tienda.envio.Modelo.Envio;
import com.tienda.envio.Repository.EnvioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnvioService {

    private static final Logger logger = LoggerFactory.getLogger(EnvioService.class);

    private final VentaClient ventaClient;
    private final EnvioRepository envioRepository;

    public EnvioService(VentaClient ventaClient, EnvioRepository envioRepository) {
        this.ventaClient = ventaClient;
        this.envioRepository = envioRepository;
    }

    public List<Envio> listar() {
        logger.info("Obteniendo todos los envios");
        return envioRepository.findAll();
    }

    public Envio findById(int id) {
        logger.info("Buscando envio con id: {}", id);
        return envioRepository.findById(id).orElse(null);
    }

    public Envio crearEnvio(EnvioRequestDTO dto) {
        logger.info("Creando envio para venta id: {}", dto.getId_venta());
        VentaResponseDTO venta;
        try {
            venta = ventaClient.getVentaPorId(dto.getId_venta());
        } catch (Exception e) {
            logger.error("Error al consultar microservicio de ventas: {}", e.getMessage());
            throw new RuntimeException("No se pudo consultar el microservicio de ventas.");
        }

        // Comparación correcta de Strings con .equals()
        if (!"Completada".equals(venta.getEstado())) {
            logger.warn("Venta {} no completada, estado: {}", dto.getId_venta(), venta.getEstado());
            throw new RuntimeException("La venta no se ha concretado");
        }

        Envio envio = new Envio();
        envio.setId_envio(venta.getId());
        envio.setEstado("En curso");
        Envio guardado = envioRepository.save(envio);
        logger.info("Envio creado con id: {}", guardado.getId_envio());
        return guardado;
    }

    public void eliminar(int id) {
        logger.info("Eliminando envio con id: {}", id);
        envioRepository.deleteById(id);
        logger.info("Envio con id {} eliminado", id);
    }
}