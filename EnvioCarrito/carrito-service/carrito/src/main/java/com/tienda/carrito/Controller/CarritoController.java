package com.tienda.carrito.Controller;

import com.tienda.carrito.dto.CarritoResponseDTO;
import com.tienda.carrito.dto.CarritoRequestDTO;
import com.tienda.carrito.Modelo.Carrito;
import com.tienda.carrito.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/API/V1/carritos")

public class CarritoController {
    @Autowired 
    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }
    
    @GetMapping 
    public ResponseEntity<List<CarritoResponseDTO>> getTodas(){
    return ResponseEntity.ok(carritoService.getTodas());}
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        CarritoResponseDTO carrito=carritoService.findById(id);
        if(carrito==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrito no encontrado");}
    return ResponseEntity.ok(carrito);}
    
   // @PutMapping 
   // public ResponseEntity<?> actualizar(@RequestBody Carrito carrito){
     //   //agregar validaciones, o agregar método en el service
      //  return ResponseEntity.ok(carritoService.guardar(carrito));
    //}
    
    @PostMapping 
    public ResponseEntity<CarritoResponseDTO> Guardar(@Valid @RequestBody CarritoRequestDTO dto){
        CarritoResponseDTO creado= carritoService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    
    
}


