package com.tienda.clienteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tienda.clienteservice.model.*;
import com.tienda.clienteservice.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<ClienteModel> listar() {
        return repo.findAll();
    }

    public ClienteModel guardar(ClienteModel cliente) {
        return repo.save(cliente);
    }

    public ClienteModel obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}