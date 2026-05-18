package com.tienda.envio.Service;
import com.tienda.envio.dto.EnvioRequestDTO;
import com.tienda.envio.dto.EnvioResponseDTO;
import com.tienda.envio.Modelo.Envio;
import com.tienda.envio.Repository.EnvioRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnvioService {
    @Autowired 
    private final EnvioRepository envioRepository;
    
    public EnvioService(EnvioRepository envioRepository){
    this.envioRepository=envioRepository;}
    
    public List<EnvioResponseDTO> getTodas(){
    return envioRepository.findAll().stream()
            .map(this::convertirAResponseDTO)
            .collect(Collectors.toList());}
    
    public EnvioResponseDTO findById(int id){
    Envio envio=envioRepository.findById(id).orElse(null);
    if(envio==null){
       return null;}
    return convertirAResponseDTO(envio);}
    
    public EnvioResponseDTO save(EnvioRequestDTO dto){
        Envio envio=new Envio();
        envio.setId_envio(dto.getId_envio());
        envio.setId_carrito(dto.getId_carrito());
        envio.setDireccion(dto.getDireccion());
        envio.setEstado(dto.getEstado());
        return convertirAResponseDTO(envio);
    }
    
    
    public void eliminar(int id){
        envioRepository.deleteById(id);}
    
    
    public EnvioResponseDTO convertirAResponseDTO(Envio envio){
       EnvioResponseDTO envioResponseDTO= new EnvioResponseDTO(
        envio.getId_envio(),
        envio.getId_carrito(),
        envio.getDireccion(),
        envio.getEstado());
           return envioResponseDTO;   }
    //AGREGAR VALIDACIONES
}

