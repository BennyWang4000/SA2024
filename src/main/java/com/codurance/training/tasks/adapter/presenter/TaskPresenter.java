package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.base.BasePresenter;
import com.codurance.training.tasks.adapter.controller.ICommandController;
import com.codurance.training.tasks.usecase.response.TaskResult;
import com.codurance.training.tasks.view.CommandCallback;

public class TaskPresenter extends BasePresenter<ICommandController> implements ITaskPresenter {

    public TaskPresenter(ICommandController controller) {
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
        // switch (cmd) {
        // case "show":
        // show(callback);
        // break;
        // case "add":
        // add(commandRest, callback);
        // break;
        // case "check":
        // setDone(commandRest[1], true, callback);
        // break;
        // case "uncheck":
        // setDone(commandRest[1], false, callback);
        // break;
        // case "help":
        // callback.onSuccess(Const.HELP_MSG);
        // break;
        // case "quit":
        // callback.onQuit();
        // break;
        // default:
        // callback.onSuccess(Const.getNoCmdMsg(cmd));
        // break;
        // }
    }

    // private void show(CommandCallback callback) {
    // TaskResult<String> result = this.model.getShow();
    // switch (result.getType()) {
    // case SUCCESS:
    // callback.onSuccess(result.getResult());
    // break;
    // case FAILURE:
    // break;
    // case ERROR:
    // callback.onError(result.getError());
    // break;
    // }
    // }

    // /* ----------------------------------- add ----------------------------------
    // */

    // private void add(String[] commandRest, CommandCallback callback) {
    // String[] subcommandRest = commandRest[1].split(" ", 2);
    // String subcommand = subcommandRest[0];
    // TaskResult<Void> result;
    // if (subcommand.equals("project")) {

    // result = this.model.addProject(subcommandRest[1]);
    // switch (result.getType()) {
    // case SUCCESS:
    // break;
    // case FAILURE:
    // callback.onFailure(result.getFailure());
    // break;
    // case ERROR:
    // callback.onError(result.getError());
    // break;
    // }

    // } else if (subcommand.equals("task")) {
    // String[] projectTask = subcommandRest[1].split(" ", 2);

    // result = this.model.addTask(projectTask[0], projectTask[1]);
    // switch (result.getType()) {
    // case SUCCESS:
    // break;
    // case FAILURE:
    // callback.onFailure(result.getFailure());
    // break;
    // case ERROR:
    // callback.onError(result.getError());
    // break;
    // }

    // }
    // }

    // /* ---------------------------------- check ---------------------------------
    // */

    // private void setDone(String idString, boolean isDone, CommandCallback
    // callback) {
    // TaskResult<Void> result = this.model.setDone(Long.parseLong(idString),
    // isDone);
    // switch (result.getType()) {
    // case SUCCESS:
    // break;
    // case FAILURE:
    // callback.onFailure(result.getFailure());
    // break;
    // case ERROR:
    // callback.onError(result.getError());
    // break;
    // }
    // }

}