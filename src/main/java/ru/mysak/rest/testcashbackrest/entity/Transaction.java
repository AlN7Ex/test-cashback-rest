package ru.mysak.rest.testcashbackrest.entity;

import lombok.Data;
import ru.mysak.rest.testcashbackrest.util.state.TransactionState;

import javax.persistence.*;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Bill bill;

    public String state;
    @Transient
    public TransactionState transactionState;

    public Transaction(Bill bill) {
        this.bill = bill;
    }

    public Transaction() {

    }
    public void action() {
        state = transactionState.getTransactionState();
    }
}
