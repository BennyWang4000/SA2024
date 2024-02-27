package com.codurance.training.base;

public abstract class BaseViewModel {
    protected BaseView view = null;

    public BaseViewModel(BaseView view) {
        this.view = view;
    }

}
