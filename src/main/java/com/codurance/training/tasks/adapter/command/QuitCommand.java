package com.codurance.training.tasks.adapter.command;

import com.codurance.training.tasks.model.ITaskModel;

public class QuitCommand extends Command {

    QuitCommand(String command, ITaskModel model) {
        super(command, model);
    }

    @Override
    public void execute() {
        model.add()
    }

}
