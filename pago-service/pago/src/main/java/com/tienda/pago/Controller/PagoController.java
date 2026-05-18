package com.tienda.pago.Controller;
import com.tienda.pago.Modelo.Pago;
import com.tienda.pago.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/API/V1/pagos")

public class PagoController {
    @Autowired
    private PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }
    @GetMapping 
    public ResponseEntity<List<Pago>> getTodas(){
        List<Pago> pagos=new ArrayList<>(); 
        pagos=pagoService.getTodas();
    return ResponseEntity.ok(pagos);}
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
    return ResponseEntity.ok(pagoService.findById(id));}
    
    @PutMapping 
    public ResponseEntity<?> actualizar(@RequestBody Pago pago){
        //agregar validaciones, o agregar método en el service
        return ResponseEntity.ok(pagoService.guardar(pago));
    }
    
    @PostMapping 
    public ResponseEntity<?> Guardar(@RequestBody Pago pago){
        return ResponseEntity.ok(pagoService.guardar(pago));
    }
    
    
}
