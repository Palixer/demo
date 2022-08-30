package com.example.demo.services.implementServices;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getClients(){
        return clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @Override
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public ClientDTO findByEmail(String email){
        Client client = clientRepository.findByEmail(email);
        ClientDTO clientDTO = new ClientDTO(client);
        return clientDTO;
    }

    @Override
    public Client findClientByEmail(String email){
        Client client = clientRepository.findByEmail(email);
        return client;
    }

    @Override
    public ClientDTO getClient(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        ClientDTO clientDTO = new ClientDTO(client);
        return clientDTO;
    }
}
