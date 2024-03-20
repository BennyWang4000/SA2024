package com.codurance.training.base;

public abstract class BasePresenter<IModel> {
    protected IModel model = null;

    public BasePresenter(IModel model) {
        this.model = model;
    };
}
