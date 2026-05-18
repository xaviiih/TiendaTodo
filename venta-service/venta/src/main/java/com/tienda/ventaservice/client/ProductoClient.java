
package com.tienda.ventaservice.client;

import com.tienda.ventaservice.dto.ProductoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="producto-service", url="http://localhost:8081")
public interface ProductoClient {

    @GetMapping("/api/v1/products/{id}")
    ProductoResponseDTO obtener(@PathVariable Long id);
}
