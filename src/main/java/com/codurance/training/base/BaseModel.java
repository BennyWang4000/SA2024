package com.codurance.training.base;

public abstract class BaseModel<IService> {
    protected IService service = null;

    protected BaseModel(IService service) {
        this.service = service;
    };
}
