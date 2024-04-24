package com.codurance.training.base.usecase.port;

public interface BaseOutput {

    public enum ResultType {
        SUCCESS,
        FAILURE,
        ERROR,
    }

    // BaseOutput succeed();

    // BaseOutput fail();

    // BaseOutput error();

    ResultType getType();
}