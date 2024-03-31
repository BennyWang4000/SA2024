package com.codurance.training.base.entity;

public abstract class BaseEntity<T> {

    protected final T id;

    protected BaseEntity(T id) {
        this.id = id;
    }

    public T getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
