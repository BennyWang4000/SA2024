package com.codurance.training.tasks.presenter;

import com.codurance.training.base.BasePresenter;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;
import com.codurance.training.tasks.model.ITaskModel;
import com.codurance.training.tasks.view.CommandCallback;

public class TaskPresenter extends BasePresenter<ITaskModel> implements ITaskPresenter {
    public TaskPresenter(ITaskModel model) {
        super(model);
    }

    /* ---------------------------------- show ---------------------------------- */

    private TaskResult<String> getShow() {
        return this.model.getShow();
    }

    /* ----------------------------------- add ---------------------------------- */

    private TaskResult<String> add(String[] commandRest) {
        String[] subcommandRest = commandRest[1].split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            return addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {

            String[] projectTask = subcommandRest[1].split(" ", 2);
            return addTask(projectTask[0], projectTask[1]);
        }
        return TaskResult.empty();
    }

    private TaskResult<String> addProject(String projectName) {
        return this.model.addProject(new ProjectName(projectName));
    }

    private TaskResult<String> addTask(String projectName, String description) {
        return this.model.addTask(
                new ProjectName(projectName),
                new Task(description,
                        new IsDone(false)));
    }

    /* ---------------------------------- check --------------------------------- */

    private TaskResult<String> check(String idString) {
        return setDone(
                new TaskId(Long.parseLong(idString)),
                new IsDone(true));
    }

    private TaskResult<String> uncheck(String idString) {
        return setDone(
                new TaskId(Long.parseLong(idString)),
                new IsDone(false));
    }

    private TaskResult<String> setDone(TaskId id, IsDone isDone) {
        return this.model.setDone(id, isDone);
    }

    @Override
    public void execute(String command, String[] commandRest, CommandCallback<String> callback) {
        TaskResult<String> result;
        switch (command) {
            case "show":
                result = getShow();
                break;
            case "add":
                result = add(commandRest);
                break;
            case "check":
                result = check(commandRest[1]);
                break;
            case "uncheck":
                result = uncheck(commandRest[1]);
                break;
            case "help":
                result = TaskResult.success(Const.helpMsg);
                break;
            case "quit":
                result = TaskResult.quit();
                break;
            default:
                result = TaskResult.success(Const.getNoCmdMsg(command));
                break;
        }

        switch (result.getType()) {
            case SUCCESS:
                callback.onSuccess((TaskResult.Success<String>) result);
                break;
            case FAILURE:
                callback.onFailure((TaskResult.Failure<String>) result);
                break;
            case ERROR:
                callback.onError((TaskResult.Error<String>) result);
                break;
            case QUIT:
                callback.onQuit();
                break;
            case EMPTY:
                callback.onEmpty();
                break;
        }
    }

}