package ru.mysak.rest.testcashbackrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.rest.testcashbackrest.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
    List<Client> findAll();
    boolean deleteClientById(Long id);


}
