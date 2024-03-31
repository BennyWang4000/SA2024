package com.codurance.training.tasks.entity;

import com.codurance.training.base.entity.BaseService;

public class MessageService extends BaseService {

    public static final String getHelpMsg() {
        return "Commands:\n" +
                "  show\n" +
                "  add project <project name>\n" +
                "  add task <project name> <task description>\n" +
                "  check <task ID>\n" +
                "  uncheck <task ID>\n";
    }

    public static final String getCmdNotFound(String cmd) {
        return String.format("I don't know what the command \"%s\" is.%n", cmd);
    }

    public static final String getProjNotFound(String name) {
        return String.format("Could not find a project with the name \"%s\".%n", name);
    }

    public static final String getTaskNotFound(long tid) {
        return String.format("Could not find a task with an ID of %d.%n", tid);
    }
}
