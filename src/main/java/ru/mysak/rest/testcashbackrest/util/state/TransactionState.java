package ru.mysak.rest.testcashbackrest.util.state;

import ru.mysak.rest.testcashbackrest.entity.Transaction;

public interface TransactionState {
    String doAction(Transaction transaction);
}
