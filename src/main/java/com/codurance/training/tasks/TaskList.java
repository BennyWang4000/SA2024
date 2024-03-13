package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.base.BaseView;
import com.codurance.training.tasks.interfaces.ITaskList;
import com.codurance.training.tasks.interfaces.ITaskListModel;
import com.codurance.training.tasks.interfaces.ITaskService;
import com.codurance.training.utils.Const;

public final class TaskList extends BaseView implements ITaskList {

    private ITaskListModel model = null;
    private boolean isRunning = true;

    public TaskList(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);

        ITaskService service = new TaskService();
        this.model = new TaskListModel(service);
    }

    @Override
    public void run() {
        while (isRunning) {
            print("> ");
            flush();
            String command;
            try {
                command = readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                printLines(this.model.getShow());
                break;
            case "add":
                printLine(this.model.add(commandRest));
                break;
            case "check":
                printLine(this.model.check(commandRest[1]));
                break;
            case "uncheck":
                printLine(this.model.uncheck(commandRest[1]));
                break;
            case "help":
                printLines(Const.helpMsg);
                break;
            case "quit":
                isRunning = false;
                break;
            default:
                printLine(Const.getNoCmdMsg(command));
                break;
        }
    }
}
