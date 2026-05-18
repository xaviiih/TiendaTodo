package com.tienda.pago.Service;
import com.tienda.pago.Modelo.Pago;
import com.tienda.pago.Repository.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }
    
    public List<Pago> getTodas(){
    return pagoRepository.findAll();}
    
    public Pago findById(int id){
    return pagoRepository.findById(id).get();}
    
    public Pago guardar(Pago pago){
       return pagoRepository.save(pago);}
    
    public void eliminar(int id){
        pagoRepository.deleteById(id);}
    
    //AGREGAR VALIDACIONES
}
