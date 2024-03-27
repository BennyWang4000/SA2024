package com.codurance.training.tasks.entity;

public class Const {

    private Const() {
        throw new IllegalStateException("utility static class");
    }

    private static final String ERR_CMD_FORMAT = "I don't know what the command \"%s\" is.\n";
    private static final String ERR_PROJ_FORMAT = "Could not find a project with the name \"%s\".\n";
    private static final String ERR_TASK_FORMAT = "Could not find a task with an ID of %d.\n";

    public static final String HELP_MSG = "Commands:\n" +
            "  show\n" +
            "  add project <project name>\n" +
            "  add task <project name> <task description>\n" +
            "  check <task ID>\n" +
            "  uncheck <task ID>\n";

    public static final String getNoCmdMsg(String cmd) {
        return String.format(ERR_CMD_FORMAT, cmd);
    }

    public static final String getNoProjMsg(String name) {
        return String.format(ERR_PROJ_FORMAT, name);
    }

    public static final String getNoTaskMsg(long tid) {
        return String.format(ERR_TASK_FORMAT, tid);
    }
}
