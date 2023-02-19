package ru.mysak.rest.testcashbackrest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.entity.Transaction;

import java.util.List;
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction findTransactionById(Long id);
    Transaction findTransactionByBillId(Long bill_id);
    List<Transaction> findAll();
    boolean deleteTransactionById(Long id);
}
