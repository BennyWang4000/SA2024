package com.codurance.training.tasks.view;

import com.codurance.training.base.BaseResult;

public interface CommandCallback<T> {

    public void onSuccess(BaseResult.Success<T> result);

    public void onFailure(BaseResult.Failure<T> result);

    public void onEmpty();

    public void onQuit();

    public void onError(BaseResult.Error<T> result);

    // void onSuccess(BaseResult.Success<T> result) {
    // };

    // void onFailure(BaseResult.Failure<T> result) {
    // };
}
