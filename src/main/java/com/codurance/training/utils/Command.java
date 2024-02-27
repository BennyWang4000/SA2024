package com.codurance.training.utils;

public enum Command {
    // ADD,
    // CHECK,
    // UNCHECK,
    // HELP,
    // QUIT;
    SHOW("show"),
    ADD("add"),
    CHECK("check"),
    UNCHECK("uncheck"),
    HELP("help"),
    QUIT("quit");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
