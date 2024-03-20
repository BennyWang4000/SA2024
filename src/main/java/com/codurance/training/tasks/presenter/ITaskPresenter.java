package com.codurance.training.tasks.presenter;

import com.codurance.training.tasks.view.CommandCallback;

public interface ITaskPresenter {

    public void execute(String command, String[] commandRest, CommandCallback<String> callback);

}
