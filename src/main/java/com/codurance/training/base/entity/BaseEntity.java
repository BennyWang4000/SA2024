package com.codurance.training.base.entity;

public abstract class BaseEntity<ID> {

    protected final ID id;

    protected BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
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
