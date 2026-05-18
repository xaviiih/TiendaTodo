package com.tienda.ventaservice.service;

import com.tienda.ventaservice.client.ClienteClient;
import com.tienda.ventaservice.client.ProductoClient;
import com.tienda.ventaservice.client.VendedorClient;
import com.tienda.ventaservice.dto.ClienteResponseDTO;
import com.tienda.ventaservice.dto.ProductoResponseDTO;
import com.tienda.ventaservice.dto.VendedorResponseDTO;
import com.tienda.ventaservice.dto.VentaRequestDTO;
import com.tienda.ventaservice.model.Venta;
import com.tienda.ventaservice.repository.VentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService {

   private static final Logger logger = LoggerFactory.getLogger(VentaService.class);

   private final VentaRepository repo;
   private final ProductoClient productoClient;
   private final ClienteClient clienteClient;
   private final VendedorClient vendedorClient;

   public VentaService(VentaRepository repo, ProductoClient productoClient,
                       ClienteClient clienteClient, VendedorClient vendedorClient) {
      this.repo = repo;
      this.productoClient = productoClient;
      this.clienteClient = clienteClient;
      this.vendedorClient = vendedorClient;
   }

   public List<Venta> listar() {
      logger.info("Obteniendo todas las ventas");
      return repo.findAll();
   }

   public Venta crearVenta(VentaRequestDTO request) {
      logger.info("Creando venta para cliente id: {}", request.getClienteId());
      ProductoResponseDTO producto;
      ClienteResponseDTO cliente;
      VendedorResponseDTO vendedor;

      try {
         producto = productoClient.obtener(request.getProductoId());
      } catch (Exception e) {
         logger.error("Error al consultar producto {}: {}", request.getProductoId(), e.getMessage());
         throw new RuntimeException("No se pudo consultar el producto");
      }
      try {
         cliente = clienteClient.obtener(request.getClienteId());
      } catch (Exception e) {
         logger.error("Error al consultar cliente {}: {}", request.getClienteId(), e.getMessage());
         throw new RuntimeException("No se pudo consultar el cliente");
      }
      try {
         vendedor = vendedorClient.obtener(request.getVendedorId());
      } catch (Exception e) {
         logger.error("Error al consultar vendedor {}: {}", request.getVendedorId(), e.getMessage());
         throw new RuntimeException("No se pudo consultar el vendedor");
      }

      Venta venta = new Venta();
      venta.setFecha(LocalDate.now());
      venta.setProductoId(producto.getId());
      venta.setProductoNombre(producto.getNombre());
      venta.setClienteId(cliente.getId());
      venta.setClienteNombre(cliente.getNombre());
      venta.setVendedorId(vendedor.getId());
      venta.setVendedorNombre(vendedor.getNombre());
      venta.setCantidad(request.getCantidad());
      venta.setTotal(producto.getPrecio() * request.getCantidad());

      Venta guardada = repo.save(venta);
      logger.info("Venta creada con id: {}", guardada.getId());
      return guardada;
   }

   public Venta obtener(Long id) {
      logger.info("Buscando venta con id: {}", id);
      Venta venta = repo.findById(id).orElse(null);
      if (venta == null) logger.warn("Venta {} no encontrada", id);
      return venta;
   }

   public void eliminar(Long id) {
      logger.info("Eliminando venta con id: {}", id);
      repo.deleteById(id);
      logger.info("Venta {} eliminada", id);
   }
}