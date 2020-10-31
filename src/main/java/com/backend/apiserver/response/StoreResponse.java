package com.backend.apiserver.response;

import lombok.Data;

@Data
public class StoreResponse {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private float latitude;

    private float longitude;

    private String company;
}
