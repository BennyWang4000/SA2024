package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.base.BasePresenter;
import com.codurance.training.tasks.adapter.controller.ITaskController;
import com.codurance.training.tasks.usecase.response.TaskResult;
import com.codurance.training.tasks.view.CommandCallback;

public class TaskPresenter extends BasePresenter<ITaskController> implements ITaskPresenter {

    public TaskPresenter(ITaskController controller) {
        super(controller);
    }

    @Override
    public void execute(String cmd, String[] commandRest, CommandCallback callback) {
        TaskResult<String> result = controller.execute(cmd, commandRest);
        switch (result.getType()) {
            case SUCCESS:
                callback.onSuccess(result.getResult());
                break;
            case FAILURE:
                callback.onFailure(result.getFailure());
                break;
            case QUIT:
                callback.onQuit();
                break;
            case ERROR:
                callback.onError(result.getError());
                break;
            case EMPTY:
                break;
        }
    }
}