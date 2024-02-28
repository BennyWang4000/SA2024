package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.base.BaseView;
import com.codurance.training.utils.Const;

public final class TaskList extends BaseView {

    public TaskList(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);
    }

    private static final String QUIT = "quit";

    private TaskListModel model = new TaskListModel(this);

    @Override
    public void run() {
        while (true) {
            writer.print("> ");
            writer.flush();
            String command;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            this.execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                this.model.show();
                break;
            case "add":
                String[] subcommandRest = commandRest[1].split(" ", 2);
                String subcommand = subcommandRest[0];
                if (subcommand.equals("project")) {
                    this.model.addProject(subcommandRest[1]);
                } else if (subcommand.equals("task")) {
                    String[] projectTask = subcommandRest[1].split(" ", 2);
                    this.model.addTask(projectTask[0], projectTask[1]);
                }
                break;
            case "check":
                this.model.check(commandRest[1]);
                break;
            case "uncheck":
                this.model.uncheck(commandRest[1]);
                break;
            case "help":
                printLine(Const.helpMsg);
                break;
            default:
                printLine(Const.getNoCmdMsg(command));
                break;
        }
    }
}
