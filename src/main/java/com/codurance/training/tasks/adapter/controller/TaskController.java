package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.base.BaseController;
import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.usecase.response.TaskResult;

public class TaskController extends BaseController<ITaskModel> implements ITaskController {

    public enum Type {
        QUIT,
        ADD,
        CHECK,
        UNCHECK,
        SHOW,
        HELP,
    }

    public enum AddType {
        PROJECT,
        TASK,
    }

    public TaskController(ITaskModel model) {
        super(model);
    }

    @Override
    public TaskResult<String> execute(String cmd, String[] cmdRest) {
        try {
            switch (Type.valueOf(cmd.toUpperCase())) {
                case QUIT:
                    return this.model.quit();
                case ADD:
                    return this.model.add(cmdRest);
                case CHECK:
                    return this.model.setDone(cmdRest, true);
                case UNCHECK:
                    return this.model.setDone(cmdRest, false);
                case SHOW:
                    return this.model.getShow();
                case HELP:
                    return this.model.getHelp();
            }
        } catch (IllegalArgumentException e) {
        }
        return this.model.getUnknown(cmd);
    }
}
