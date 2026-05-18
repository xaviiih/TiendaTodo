
package com.tienda.ventaservice.client;

import com.tienda.ventaservice.dto.VendedorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="vendedor-service", url="http://localhost:8084")
public interface VendedorClient {

    @GetMapping("/API/V1/vendedores/{id}")
    VendedorResponseDTO obtener(@PathVariable Long id);
}
