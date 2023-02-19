package ru.mysak.rest.testcashbackrest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Transaction(Bill bill, String state) {
        this.bill = bill;
        this.state = state;
    }

    public Transaction() {

    }
}
