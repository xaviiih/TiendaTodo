package com.tienda.valoracion.Service;
import com.tienda.valoracion.Modelo.Valoracion;
import com.tienda.valoracion.Repository.ValoracionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional

/**
 *
 * @author Arlettee
 */
public class ValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepository;

    public ValoracionService(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }
    
    public List<Valoracion> getTodas(){
    return valoracionRepository.findAll();}
    
    public Valoracion findById(int id){
    return valoracionRepository.findById(id).get();}
    
    public Valoracion guardar(Valoracion valoracion){
    return valoracionRepository.save(valoracion);}
    
    public void eliminar(int id){
        valoracionRepository.deleteById(id);}
    
}

