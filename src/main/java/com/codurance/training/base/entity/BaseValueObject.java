package com.codurance.training.base.entity;

public class BaseValueObject<V> {

    protected final V value;

    protected BaseValueObject(V value) {
        this.value = value;
    }

    public V getValue() {
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
