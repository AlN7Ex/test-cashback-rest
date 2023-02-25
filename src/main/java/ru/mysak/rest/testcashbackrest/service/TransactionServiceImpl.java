package ru.mysak.rest.testcashbackrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.TransactionalStateType;
import ru.mysak.rest.testcashbackrest.entity.Transaction;
import ru.mysak.rest.testcashbackrest.repository.TransactionRepository;
import ru.mysak.rest.testcashbackrest.util.state.CreatedTransactionState;
import ru.mysak.rest.testcashbackrest.util.state.TransactionState;
import ru.mysak.rest.testcashbackrest.util.state.TransactionStateFactory;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionStateFactory transactionStateFactory;
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
        new CreatedTransactionState().doAction(transaction);
        transaction.action();
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean update(Transaction transaction, TransactionalStateType stateType) {
        TransactionState transactionState = transactionStateFactory.getState(stateType);
        transactionState.doAction(transaction);
        transaction.action();
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
