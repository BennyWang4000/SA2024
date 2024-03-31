package com.codurance.training.tasks.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.base.BaseView;
import com.codurance.training.tasks.adapter.controller.TaskController;
import com.codurance.training.tasks.adapter.controller.ITaskController;
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
        ITaskController controller = new TaskController(model);
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

        this.presenter.execute(commandLine, callback);

    }
}
