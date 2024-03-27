package com.codurance.training.tasks.view;

public interface CommandCallback {

    public void onSuccess(String result);

    public void onQuit();

    public void onError(Throwable result);

}
