package ru.mysak.rest.testcashbackrest.service;

import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.entity.Transaction;

import java.util.List;

@Service
public interface TransactionService {

    Transaction read(Long id);
    Transaction readByBillId(Long bill_id);
    List<Transaction> readAll();
    boolean create(Transaction transaction);
    boolean update(Transaction transaction);
    boolean delete(Long id);
}
