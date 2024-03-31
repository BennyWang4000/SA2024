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
                    String[] typeRest = cmdRest[1].split(" ", 2);
                    switch (AddType.valueOf(typeRest[0].toUpperCase())) {
                        case PROJECT:
                            return this.model.addProject(typeRest[1]);
                        case TASK:
                            return this.model.addTask(
                                    typeRest[1].split(" ", 2)[0],
                                    typeRest[1].split(" ", 2)[1]);
                        default:
                    }
                    break;
                case CHECK:
                    return this.model.setDone(cmdRest, true);
                case UNCHECK:
                    return this.model.setDone(cmdRest, false);
                case SHOW:
                    return this.model.getShow();
                case HELP:
                    return this.model.getHelp();
            }
        } catch (Exception e) {
            return this.model.getUnknown(cmd);
        }
        return this.model.getUnknown(cmd);
    }
}
