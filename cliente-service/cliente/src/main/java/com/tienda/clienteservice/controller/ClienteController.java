package com.tienda.clienteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tienda.clienteservice.model.*;
import com.tienda.clienteservice.service.ClienteService;

@RestController
@RequestMapping("API/V1/clientes")

public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteModel> listar() {
        return service.listar();
    }

    @PostMapping
    public ClienteModel guardar(@RequestBody ClienteModel cliente) {
        return service.guardar(cliente);
    }

    @GetMapping("/{id}")
    public ClienteModel obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public ClienteModel actualizar(@PathVariable Long id, @RequestBody ClienteModel cliente) {
        cliente.setId(id);
        return service.guardar(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}