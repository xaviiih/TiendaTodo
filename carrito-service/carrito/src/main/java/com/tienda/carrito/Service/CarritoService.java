package com.tienda.carrito.Service;
import com.tienda.carrito.dto.CarritoRequestDTO;
import com.tienda.carrito.dto.CarritoResponseDTO;
import com.tienda.carrito.Modelo.Carrito;
import com.tienda.carrito.Repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarritoService {

    private static final Logger logger = LoggerFactory.getLogger(CarritoService.class);

    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<CarritoResponseDTO> getTodas() {
        logger.info("Obteniendo todos los carritos");
        return carritoRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    public CarritoResponseDTO findById(int id) {
        logger.info("Buscando carrito con id: {}", id);
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if (carrito == null) {
            logger.warn("Carrito con id {} no encontrado", id);
            return null;
        }
        return convertirAResponseDTO(carrito);
    }

    public CarritoResponseDTO guardar(CarritoRequestDTO dto) {
        logger.info("Guardando nuevo carrito");
        Carrito carrito = new Carrito();
        carrito.setId_carrito(dto.getId_carrito());
        carrito.setFecha(dto.getFecha());
        carrito.setCant_productos(dto.getCant_productos());
        carrito.setTotal(dto.getTotal());
        Carrito guardado = carritoRepository.save(carrito);
        logger.info("Carrito guardado con id: {}", guardado.getId_carrito());
        return convertirAResponseDTO(guardado);
    }

    public void eliminar(int id) {
        logger.info("Eliminando carrito con id: {}", id);
        carritoRepository.deleteById(id);
        logger.info("Carrito con id {} eliminado", id);
    }

    private CarritoResponseDTO convertirAResponseDTO(Carrito carrito) {
        return new CarritoResponseDTO(
                carrito.getId_carrito(),
                carrito.getFecha(),
                carrito.getCant_productos(),
                carrito.getTotal()
        );
    }
}