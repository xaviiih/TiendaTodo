package com.tienda.valoracion.Controller;
import com.tienda.valoracion.Modelo.Valoracion;
import com.tienda.valoracion.Service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/API/V1/valoraciones")
/**
 *
 * @author Arlettee
 */
public class ValoracionController {
    @Autowired 
    private ValoracionService valoracionService;

    public ValoracionController(ValoracionService valoracionService) {
        this.valoracionService = valoracionService;
    }
    
    @GetMapping 
    public ResponseEntity<List<Valoracion>> getTodas(){
        List<Valoracion> valoraciones=new ArrayList<>(); 
        valoraciones=valoracionService.getTodas();
    return ResponseEntity.ok(valoraciones);}
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
    return ResponseEntity.ok(valoracionService.findById(id));}
    
    @PutMapping 
    public ResponseEntity<?> actualizar(@RequestBody Valoracion valoracion){
        //agregar validaciones, o agregar método en el service
        return ResponseEntity.ok(valoracionService.guardar(valoracion));
    }
    
    @PostMapping 
    public ResponseEntity<?> Guardar(@RequestBody Valoracion valoracion){
        return ResponseEntity.ok(valoracionService.guardar(valoracion));
    }
    
}

