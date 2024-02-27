package com.codurance.training.utils;

public class Const {

    private final static String errCmdFormat = "I don't know what the command \"%s\" is.";
    private final static String errProjFormat = "Could not find a project with the name \"%s\".";
    private final static String errTaskFormat = "Could not find a task with an ID of %d.";

    public static final String helpMsg = "Commands:\n    show\n    add project <project name>\n    add task <project name> <task description>\n    check <task ID>\n    uncheck <task ID>\n";

    public static String getNoCmdMsg(String cmd) {
        return String.format(errCmdFormat, cmd);
    };

    public static String getNoProjMsg(String cmd) {
        return String.format(errProjFormat, cmd);
    };

    public static String getNoTaskMsg(long tid) {
        return String.format(errTaskFormat, tid);
    };
}
