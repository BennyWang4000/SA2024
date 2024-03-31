package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseValueObject;

public class TaskId extends BaseValueObject<Long> {

    public TaskId(long id) {
        super(id);
    }

    public long getId() {
        return this.value;
    }
}
