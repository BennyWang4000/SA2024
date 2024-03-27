package com.codurance.training.tasks.entity.task;

public final class Task {
    private final TaskId id;
    private final String description;
    private IsDone isDone;

    public Task(long id, String description, boolean done) {
        this.id = new TaskId(id);
        this.description = description;
        this.isDone = new IsDone(done);
    }

    public TaskId getId() {
        return this.id;
    }

    public IsDone isDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone.setDone(done);
    }

    public String getShow() {
        return String.format("    [%c] %d: %s",
                this.isDone.getShow(),
                this.id.getId(),
                this.description);
    }
}
