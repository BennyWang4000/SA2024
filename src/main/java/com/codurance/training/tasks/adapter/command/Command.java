package com.codurance.training.tasks.adapter.command;

import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.view.CommandCallback;

public abstract class Command {

    public enum Type {
        QUIT("quit"),
        ADD("add"),
        CHECK("check"),
        UNCHECK("uncheck"),
        SHOW("show"),
        UNKNOWN("");

        public final String command;

        Type(String command) {
            this.command = command;
        }

    }

    private final Type type;
    private final ITaskModel model;
    private final CommandCallback callback;
    private final Command executor;

    protected Command(String command, ITaskModel model, CommandCallback callback) {
        this.type = Type.valueOf(command);
        this.model = model;
        this.callback = callback;
        switch (this.type) {
            case QUIT:
                break;
                this.executor = new QuitCommand(command, model);
            default:
                break;
        }
    }

    public Type getType() {
        return this.type;
    }

    public abstract void execute(String[] args);
}
