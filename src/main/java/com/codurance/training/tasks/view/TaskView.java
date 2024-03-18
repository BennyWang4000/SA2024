package com.codurance.training.tasks.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.base.BaseResult;
import com.codurance.training.base.BaseResult.Error;
import com.codurance.training.base.BaseView;
import com.codurance.training.tasks.entity.service.ITaskService;
import com.codurance.training.tasks.entity.service.TaskService;
import com.codurance.training.tasks.model.ITaskModel;
import com.codurance.training.tasks.model.TaskModel;
import com.codurance.training.tasks.presenter.ITaskPresenter;
import com.codurance.training.tasks.presenter.TaskPresenter;

public final class TaskView extends BaseView implements ITaskView {

    private ITaskPresenter presenter = null;
    private boolean isRunning = true;

    public TaskView(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);
        ITaskService service = new TaskService();
        ITaskModel model = new TaskModel(service);
        this.presenter = new TaskPresenter(model);
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

        CommandCallback<String> callback = new CommandCallback<String>() {

            @Override
            public void onSuccess(BaseResult.Success<String> result) {
                printLine(result.getResult());
            }

            @Override
            public void onFailure(BaseResult.Failure<String> result) {
                printLine(result.getResult());
            }

            @Override
            public void onQuit() {
                isRunning = false;
            }

            @Override
            public void onEmpty() {
            }

            @Override
            public void onError(Error<String> result) {
                printLine(result.getError().toString());
            }
        };

        this.presenter.execute(command, commandRest, callback);

    }
}
