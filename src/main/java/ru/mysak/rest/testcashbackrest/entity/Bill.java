package ru.mysak.rest.testcashbackrest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double deposit;
    private double cashback;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Client client;
}
