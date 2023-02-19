package ru.mysak.rest.testcashbackrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Client;
import ru.mysak.rest.testcashbackrest.entity.Transaction;
import ru.mysak.rest.testcashbackrest.repository.TransactionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public Transaction read(Long id) {
        return transactionRepository.findTransactionById(id);
    }

    @Override
    public Transaction readByBillId(Long bill_id) {
        return transactionRepository.findTransactionByBillId(bill_id);
    }

    @Override
    public List<Transaction> readAll() {
        return null;
    }

    @Override
    public boolean create(Transaction transaction) {
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean update(Transaction transaction) {
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
