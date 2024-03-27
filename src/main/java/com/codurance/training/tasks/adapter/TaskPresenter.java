package com.codurance.training.tasks.adapter;

import com.codurance.training.base.BasePresenter;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.view.CommandCallback;

public class TaskPresenter extends BasePresenter<ITaskModel> implements ITaskPresenter {
    public TaskPresenter(ITaskModel model) {
        super(model);
    }

    /* ----------------------------------- add ---------------------------------- */

    private void add(String[] commandRest) {
        String[] subcommandRest = commandRest[1].split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);

        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
    }

    private void addProject(String name) {
        this.model.addProject(name);
    }

    private void addTask(String name, String description) {
        this.model.addTask(name, description);
    }

    /* ---------------------------------- check --------------------------------- */

    private void setDone(String idString, boolean isDone) {
        this.model.setDone(Long.parseLong(idString), isDone);
    }

    @Override
    public void execute(String command, String[] commandRest, CommandCallback callback) {

        // switch (command) {
        // case "show":
        // callback.onSuccess(this.model.getShow());
        // break;
        // case "add":
        // add(commandRest);
        // break;
        // case "check":
        // setDone(commandRest[1], true);
        // break;
        // case "uncheck":
        // setDone(commandRest[1], false);
        // break;
        // case "help":
        // callback.onSuccess(Const.HELP_MSG);
        // break;
        // case "quit":
        // callback.onQuit();
        // break;
        // default:
        // callback.onSuccess(Const.getNoCmdMsg(command));
        // break;
        // }
    }

}