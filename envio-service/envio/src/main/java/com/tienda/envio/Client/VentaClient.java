/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.envio.Client;
import com.tienda.envio.dto.VentaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Arlettee
 */
@FeignClient(name="venta", url= "http://localhost:1083")
public interface VentaClient {
@GetMapping("/API/V1/venta/{id}")
VentaResponseDTO getVentaPorId(@PathVariable("id") int id);

    
    
}
