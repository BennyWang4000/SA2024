package com.codurance.training.tasks.entity.task;

public class IsDone {
    private boolean done;

    public IsDone(boolean isDone) {
        this.done = isDone;
    }

    public char getShow() {
        return this.done ? 'x' : ' ';
    }

    public void setDone(boolean isDone) {
        this.done = isDone;
    }

    public boolean getDone() {
        return this.done;
    }
}
