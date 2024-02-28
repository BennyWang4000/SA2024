package com.codurance.training.base;

public abstract class BaseModel {
    protected BaseView view = null;

    public BaseModel(BaseView view) {
        this.view = view;
    }

}
