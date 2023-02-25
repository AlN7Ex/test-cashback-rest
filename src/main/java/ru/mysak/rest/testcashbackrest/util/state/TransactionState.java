package ru.mysak.rest.testcashbackrest.util.state;

import ru.mysak.rest.testcashbackrest.entity.Transaction;

public interface TransactionState {
    void doAction(Transaction transaction);
    String getTransactionState();
}
