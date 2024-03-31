package com.codurance.training.base.entity;

public class BaseValueObject<T> {

    protected final T value;

    protected BaseValueObject(T value) {
        this.value = value;
    }

    public BaseValueObject<T> of(T value) {
        return new BaseValueObject<>(value);
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
