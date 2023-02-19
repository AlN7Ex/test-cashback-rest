package ru.mysak.rest.testcashbackrest.util.state;

public class ComletedTransactionState implements TransactionState{
    @Override
    public String setState() {
        return "Transaction completed";
    }
}
