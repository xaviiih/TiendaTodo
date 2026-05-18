package com.tienda.sucursal.Service;
import com.tienda.sucursal.Modelo.Sucursal;
import com.tienda.sucursal.Repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional



public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }
    public List<Sucursal> getTodas(){
    return sucursalRepository.findAll();}
    
    public Sucursal findById(int id){
    return sucursalRepository.findById(id).get();}
    
    public Sucursal guardar(Sucursal sucursal){
    return sucursalRepository.save(sucursal);}
    
    public void eliminar(int id){
        sucursalRepository.deleteById(id);}
    
}
