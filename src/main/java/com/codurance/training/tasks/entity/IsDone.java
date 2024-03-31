package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseValueObject;

public class IsDone extends BaseValueObject<Boolean> {

    public IsDone(Boolean isDone) {
        super(isDone);
    }

    public static IsDone of(boolean isDone) {
        return new IsDone(isDone);
    }

    public boolean getIsDone() {
        return this.value;
    }

    public char getShow() {
        return Boolean.TRUE.equals(this.value) ? 'x' : ' ';
    }

}
