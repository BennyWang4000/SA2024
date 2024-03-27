package com.codurance.training.tasks.adapter.presenter;

import com.codurance.training.tasks.view.CommandCallback;

public interface ITaskPresenter {

    public void execute(String command, String[] commandRest, CommandCallback callback);

}
