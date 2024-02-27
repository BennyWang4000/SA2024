package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.BaseView;
import com.codurance.training.base.Task;
import com.codurance.training.utils.Const;

public final class TaskView extends BaseView {

    public TaskView(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);
    }

    private static final String QUIT = "quit";

    private TaskViewModel viewModel = new TaskViewModel(this);

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
                show();
                break;
            case "add":
                this.viewModel.add(commandRest[1]);
                break;
            case "check":
                this.viewModel.check(commandRest[1]);
                break;
            case "uncheck":
                this.viewModel.uncheck(commandRest[1]);
                break;
            case "help":
                printLine(Const.helpMsg);
                break;
            default:
                printLine(Const.getNoCmdMsg(command));
                break;
        }
    }

    private void show() {
        for (Map.Entry<String, List<Task>> project : this.viewModel.getProjects().entrySet()) {
            writer.println(project.getKey());
            for (Task task : project.getValue()) {
                writer.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            writer.println();
        }
    }

}
