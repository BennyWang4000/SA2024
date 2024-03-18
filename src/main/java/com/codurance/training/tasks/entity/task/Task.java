package com.codurance.training.tasks.entity.task;

public final class Task {
    // private final TaskId id;
    private final String description;
    private IsDone done;

    public Task(String description, IsDone done) {
        // this.id = id;
        this.description = description;
        this.done = done;
    }

    // public Task(TaskId id, String description, boolean done) {
    // this.id = id;
    // this.description = description;
    // this.done = done;
    // }

    // public TaskId getId() {
    // return id;
    // }

    public String getDescription() {
        return description;
    }

    public IsDone isDone() {
        return done;
    }

    public void setDone(IsDone done) {
        this.done = done;
    }

    public String getShow(long id) {
        return String.format("    [%c] %d: %s", (this.isDone().getIsDone() ? 'x' : ' '), id, this.getDescription());
    }
}
