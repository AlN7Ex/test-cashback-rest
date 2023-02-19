package ru.mysak.rest.testcashbackrest.service;

import ru.mysak.rest.testcashbackrest.entity.Client;

import java.util.List;

public interface ClientService {

    Client read(Long id);
    List<Client> readAll();
    boolean create(Client client);
    boolean update(Client client, Long id);
    boolean delete(Long id);

}
