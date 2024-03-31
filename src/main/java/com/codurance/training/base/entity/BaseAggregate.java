package com.codurance.training.base.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAggregate<ID, IC> {

    protected final ID id;

    protected final List<IC> contents;

    protected BaseAggregate(ID id) {
        this.id = id;
        this.contents = new ArrayList<>();
    }
}
