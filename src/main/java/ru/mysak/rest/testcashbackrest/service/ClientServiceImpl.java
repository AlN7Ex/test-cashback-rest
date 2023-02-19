package ru.mysak.rest.testcashbackrest.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client read(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public List<Client> readAll() {
        return null;
    }

    @Override
    public boolean create(Client client) {
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean update(Client client, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
