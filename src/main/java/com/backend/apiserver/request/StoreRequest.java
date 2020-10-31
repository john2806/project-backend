package com.backend.apiserver.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StoreRequest {

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    private float latitude;

    private float longitude;

    private String company;
}
