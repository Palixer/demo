package com.example.demo.services;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.models.Client;

import java.util.List;

public interface ClientService {
    public List<ClientDTO> getClients();
    public Client saveClient(Client client);
    public ClientDTO getClient(Long id);
    public ClientDTO findByEmail(String email);
    public Client findClientByEmail(String email);
}
