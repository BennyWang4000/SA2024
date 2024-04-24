package com.codurance.training.tasks.usecase.command;

public abstract class BaseTaskOperation<IR> {

    protected final IR repository;

    protected BaseTaskOperation(IR repository) {
        this.repository = repository;
    }
}
