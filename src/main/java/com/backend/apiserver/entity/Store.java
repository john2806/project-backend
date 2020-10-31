package com.backend.apiserver.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private float latitude;

    private float longitude;

    private String company;

}
