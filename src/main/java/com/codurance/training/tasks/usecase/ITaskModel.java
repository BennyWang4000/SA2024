package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.adapter.response.TaskResult;

public interface ITaskModel {

    /* ---------------------------------- show ---------------------------------- */

    public TaskResult<String> getShow();

    public TaskResult<String> getHelp();

    public TaskResult<String> getUnknown(String command);

    public TaskResult<String> quit();

    /* ----------------------------------- add ---------------------------------- */

    public TaskResult<String> addProject(String name);

    public TaskResult<String> addTask(String name, String description);

    /* ---------------------------------- check --------------------------------- */

    public TaskResult<String> setDone(String[] cmdRest, boolean isDone);

}
