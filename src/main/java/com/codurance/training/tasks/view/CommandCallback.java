package com.codurance.training.tasks.view;

import com.codurance.training.tasks.entity.response.TaskResult;

public interface CommandCallback<T> {

    public void onSuccess(TaskResult.Success<T> result);

    public void onFailure(TaskResult.Failure<T> result);

    public void onEmpty();

    public void onQuit();

    public void onError(TaskResult.Error<T> result);

}
