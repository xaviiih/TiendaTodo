
package com.tienda.ventaservice.client;

import com.tienda.ventaservice.dto.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cliente-service", url="http://localhost:8083")
public interface ClienteClient {

    @GetMapping("/API/V1/clientes/{id}")
    ClienteResponseDTO obtener(@PathVariable Long id);
}
