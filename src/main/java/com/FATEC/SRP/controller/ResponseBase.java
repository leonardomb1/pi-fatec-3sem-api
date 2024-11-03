package com.fatec.srp.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseBase<T> {
    private String info;
    private boolean error;
    private int status;
    private T message;
}