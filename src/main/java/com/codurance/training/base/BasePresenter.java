package com.codurance.training.base;

public abstract class BasePresenter<IC> {
    protected IC controller;

    protected BasePresenter(IC controller) {
        this.controller = controller;
    }
}
