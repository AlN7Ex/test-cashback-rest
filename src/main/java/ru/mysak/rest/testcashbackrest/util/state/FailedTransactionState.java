package ru.mysak.rest.testcashbackrest.util.state;

public class FailedTransactionState implements TransactionState{
    @Override
    public String setState() {
        return "Failed transaction";
    }
}
