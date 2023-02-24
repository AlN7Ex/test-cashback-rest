package ru.mysak.rest.testcashbackrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.service.ClientServiceImpl;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;

    @GetMapping("/{client_id}")
    public Client client(@PathVariable Long client_id) {
        return clientService.read(client_id);
    }
}
