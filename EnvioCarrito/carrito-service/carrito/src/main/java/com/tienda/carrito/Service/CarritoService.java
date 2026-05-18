package com.tienda.carrito.Service;
import com.tienda.carrito.dto.CarritoRequestDTO;
import com.tienda.carrito.dto.CarritoResponseDTO;
import com.tienda.carrito.Modelo.Carrito;
import com.tienda.carrito.Repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional

public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }
    
    public List<CarritoResponseDTO> getTodas(){
    return carritoRepository.findAll()
            .stream()
            .map(this::convertirAResponseDTO)
            .collect(Collectors.toList());}
    
   
    public CarritoResponseDTO findById(int id){
    Carrito carrito=carritoRepository.findById(id).orElse(null);
    if(carrito==null){return null;}
    return convertirAResponseDTO(carrito);}
    
    public CarritoResponseDTO guardar(CarritoRequestDTO dto){
    Carrito carrito=new Carrito();
    carrito.setId_carrito(dto.getId_carrito());
    carrito.setFecha(dto.getFecha());
    carrito.setCant_productos(dto.getCant_productos());
    carrito.setTotal(dto.getTotal());
    
    Carrito guardado=carritoRepository.save(carrito);
    return convertirAResponseDTO(guardado);
        }
    
    public void eliminar(int id){
        carritoRepository.deleteById(id);}
     
 
    private CarritoResponseDTO convertirAResponseDTO(Carrito carrito){
        return new CarritoResponseDTO(
                carrito.getId_carrito(),
                carrito.getFecha(),
                carrito.getCant_productos(),
                 carrito.getTotal()
            );}
                    
    
    //AGREGAR VALIDACIONES
    
    
}
