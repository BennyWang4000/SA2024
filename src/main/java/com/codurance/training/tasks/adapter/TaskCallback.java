package com.codurance.training.tasks.adapter;

public interface TaskCallback {

    public void onSuccess(String result);

    public void onFailure(String result);

    public void onError(Throwable result);

}
