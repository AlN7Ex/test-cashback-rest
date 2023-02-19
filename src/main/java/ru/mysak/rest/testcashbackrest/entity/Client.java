package ru.mysak.rest.testcashbackrest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "first_name", nullable = false)
    public String firstName;
    @Column(name = "last_name", nullable = false)
    public String lastName;
}
