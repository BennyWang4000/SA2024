package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseEntity;

public final class Task extends BaseEntity<TaskId> {
    private final String description;
    private IsDone isDone;

    public Task(Long id, String description, boolean done) {
        super(new TaskId(id));
        this.description = description;
        this.isDone = new IsDone(done);
    }

    public IsDone isDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone = new IsDone(done);
    }

    public String getShow() {
        return String.format("    [%c] %d: %s",
                this.isDone.getShow(),
                this.id.getId(),
                this.description);
    }
}
