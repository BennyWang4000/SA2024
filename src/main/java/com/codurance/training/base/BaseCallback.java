package com.codurance.training.base;

public interface BaseCallback<T> {

    void onSuccess(BaseResult.Success<T> result);

    void onFailure(BaseResult.Failure<T> result);
}
