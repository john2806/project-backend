package com.backend.apiserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseWrapper {
    private List<? extends Object> data;
}
