
package com.tienda.ProductoService.client;

import com.tienda.ProductoService.dto.ProveedorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "proveedor-service", url = "http://localhost:8085")
public interface ProveedorClient {

    @GetMapping("/API/V1/proveedores/{id}")
    ProveedorResponseDTO obtenerProveedor(@PathVariable Long id);
}
