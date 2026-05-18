package com.tienda.sucursal.Controller;
import com.tienda.sucursal.Modelo.Sucursal;
import com.tienda.sucursal.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/API/V1/sucursales")

/**
 *
 * @author Arlettee
 */
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }
    
    @GetMapping 
    public ResponseEntity<List<Sucursal>> getTodas(){
        List<Sucursal> sucursales=new ArrayList<>(); 
        sucursales=sucursalService.getTodas();
    return ResponseEntity.ok(sucursales);}
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
    return ResponseEntity.ok(sucursalService.findById(id));}
    
    @PutMapping 
    public ResponseEntity<?> actualizar(@RequestBody Sucursal sucursal){
        //agregar validaciones, o agregar método en el service
        return ResponseEntity.ok(sucursalService.guardar(sucursal));
    }
    
    @PostMapping 
    public ResponseEntity<?> Guardar(@RequestBody Sucursal sucursal){
        return ResponseEntity.ok(sucursalService.guardar(sucursal));
    }
    
}

