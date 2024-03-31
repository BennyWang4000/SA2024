package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.usecase.response.TaskResult;

public interface ITaskController {

    public TaskResult<String> execute(String cmd, String[] cmdRest);
}