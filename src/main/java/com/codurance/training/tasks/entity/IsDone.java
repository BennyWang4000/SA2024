package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseValueObject;

public class IsDone extends BaseValueObject<Boolean> {

    public static IsDone of(Boolean value) {
        return new IsDone(value);
    }

    public IsDone(Boolean isDone) {
        super(isDone);
    }

    public char getShow() {
        return Boolean.TRUE.equals(this.value) ? 'x' : ' ';
    }

}
