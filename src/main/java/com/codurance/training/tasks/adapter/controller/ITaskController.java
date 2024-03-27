package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.usecase.response.TaskResult;

public interface ITaskController {

    public <T> TaskResult<T> execute(String cmd, String[] cmdRest);
}