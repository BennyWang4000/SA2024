package com.codurance.training.tasks.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.base.BaseView;
import com.codurance.training.tasks.adapter.controller.CommandController;
import com.codurance.training.tasks.adapter.controller.ICommandController;
import com.codurance.training.tasks.adapter.presenter.ITaskPresenter;
import com.codurance.training.tasks.adapter.presenter.TaskPresenter;
import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.usecase.TaskModel;

public final class TaskView extends BaseView implements ITaskView {

    private ITaskPresenter presenter = null;
    private boolean isRunning = true;

    public TaskView(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);

        ITaskModel model = new TaskModel();
        ICommandController controller = new CommandController(model);
        this.presenter = new TaskPresenter(controller);
    }

    @Override
    public void run() {
        while (isRunning) {
            writer.print("> ");
            writer.flush();
            String command;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.execute(command);
        }
    }

    private void execute(String commandLine) {
        String command = commandLine.split(" ", 2)[0];
        String[] commandRest = commandLine.split(" ", 2);

        CommandCallback callback = new CommandCallback() {

            @Override
            public void onSuccess(String result) {
                if (!result.equals(""))
                    writer.print(result);
            }

            @Override
            public void onFailure(String result) {
                writer.println(result);
            }

            @Override
            public void onQuit() {
                isRunning = false;
            }

            @Override
            public void onError(Throwable result) {
                writer.println(result.toString());
            }

        };

        this.presenter.execute(command, commandRest, callback);

    }
}
