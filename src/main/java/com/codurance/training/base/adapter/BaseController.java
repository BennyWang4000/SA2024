package com.codurance.training.base.adapter;

public abstract class BaseController<IM> {
    protected final IM model;

    protected BaseController(IM model) {
        this.model = model;
    }
}
