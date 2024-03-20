package com.codurance.training.tasks.entity.task;

public class TaskId {
    final long id;

    public TaskId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
