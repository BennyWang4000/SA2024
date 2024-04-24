package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseEntity;

public class Task extends BaseEntity<TaskId> {
    private final String description;
    private IsDone isDone;

    public Task(TaskId id, String description, IsDone isDone) {
        super(id);
        this.description = description;
        this.isDone = isDone;
    }

    public IsDone isDone() {
        return this.isDone;
    }

    public void setDone(IsDone isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getShow() {
        return String.format("    [%c] %d: %s",
                this.isDone.getShow(),
                this.id.getId(),
                this.description);
    }
}
