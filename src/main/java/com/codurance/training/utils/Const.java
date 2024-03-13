package com.codurance.training.utils;

import java.util.List;

public class Const {

    private static final String errCmdFormat = "I don't know what the command \"%s\" is.";
    private static final String errProjFormat = "Could not find a project with the name \"%s\".";
    private static final String errTaskFormat = "Could not find a task with an ID of %d.";

    public static final List<String> helpMsg = List.of(
            "Commands:",
            "  show",
            "  add project <project name>",
            "  add task <project name> <task description>",
            "  check <task ID>",
            "  uncheck <task ID>");

    public static final String getNoCmdMsg(String cmd) {
        return String.format(errCmdFormat, cmd);
    };

    public static final String getNoProjMsg(String cmd) {
        return String.format(errProjFormat, cmd);
    };

    public static final String getNoTaskMsg(long tid) {
        return String.format(errTaskFormat, tid);
    };
}
