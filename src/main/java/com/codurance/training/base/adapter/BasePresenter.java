package com.codurance.training.base.adapter;

public abstract class BasePresenter<C, IC> {
    protected C callback;
    protected IC controller;

    protected BasePresenter(C callback, IC controller) {
        this.callback = callback;
        this.controller = controller;
    }
}
