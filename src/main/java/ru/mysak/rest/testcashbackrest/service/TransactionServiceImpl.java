package ru.mysak.rest.testcashbackrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Transaction;
import ru.mysak.rest.testcashbackrest.repository.TransactionRepository;
import ru.mysak.rest.testcashbackrest.util.state.CreatedTransactionState;
import ru.mysak.rest.testcashbackrest.util.state.TransactionState;

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
        String created = new CreatedTransactionState().doAction(transaction);
        transaction.setState(created);
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean update(Transaction transaction, TransactionState transactionState) {
        String state = transactionState.doAction(transaction);
        transaction.setState(state);
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
