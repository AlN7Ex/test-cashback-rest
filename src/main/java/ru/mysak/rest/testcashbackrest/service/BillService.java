package ru.mysak.rest.testcashbackrest.service;

import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Bill;
import ru.mysak.rest.testcashbackrest.entity.Client;

import java.util.List;

@Service
public interface BillService {
    Bill read(Long id);
    Bill readByClientId(Long client_id);
    List<Bill> readAll();
    boolean create(Bill bill);
    boolean update(Bill bill);
    boolean delete(Long id);
}
