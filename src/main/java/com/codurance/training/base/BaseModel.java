package com.codurance.training.base;

public abstract class BaseModel<IService> {
    protected IService service;

    public BaseModel(IService service) {
        this.service = service;
    };
}
