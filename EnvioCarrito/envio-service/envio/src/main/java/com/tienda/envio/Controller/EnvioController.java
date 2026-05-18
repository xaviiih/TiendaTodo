package com.tienda.envio.Controller;
import com.tienda.envio.dto.EnvioRequestDTO;
import com.tienda.envio.dto.EnvioResponseDTO;
import com.tienda.envio.Modelo.Envio;
import com.tienda.envio.Service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/API/V1/envios")

public class EnvioController {
    @Autowired 
    private EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }
    
    @GetMapping 
    public ResponseEntity<List<EnvioResponseDTO>> getTodas(){
    return ResponseEntity.ok(envioService.getTodas());}
    
    @GetMapping("/{id}")
    public ResponseEntity<EnvioResponseDTO> findById(@PathVariable int id){
        EnvioResponseDTO envio=(envioService.findById(id));
        if(envio==null){
            return null;}
        return ResponseEntity.ok(envio);}
    
    //@PutMapping 
    //public ResponseEntity<Envio> actualizar(@RequestBody Envio envio){
        //agregar validaciones, o agregar método en el service
    //    return ResponseEntity.ok(envioService.save((envio));
    //}
    
    @PostMapping 
    public ResponseEntity<EnvioResponseDTO> Guardar(@Valid @RequestBody EnvioRequestDTO envio){
        EnvioResponseDTO guardado= envioService.save(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
    
}
