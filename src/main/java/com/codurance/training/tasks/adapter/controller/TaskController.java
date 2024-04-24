package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.base.adapter.BaseController;
import com.codurance.training.tasks.adapter.presenter.IQuitPresenter;
import com.codurance.training.tasks.adapter.presenter.IShowPresenter;
import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.usecase.command.add.AddProjectInput;
import com.codurance.training.tasks.usecase.command.add.AddTaskInput;
import com.codurance.training.tasks.usecase.command.add.IAddProjectUsecase;
import com.codurance.training.tasks.usecase.command.add.IAddTaskUsecase;
import com.codurance.training.tasks.usecase.command.check.CheckInput;
import com.codurance.training.tasks.usecase.command.check.ICheckUsecase;
import com.codurance.training.tasks.usecase.command.quit.IQuitUsecase;
import com.codurance.training.tasks.usecase.command.quit.QuitInput;
import com.codurance.training.tasks.usecase.command.show.IShowUsecase;
import com.codurance.training.tasks.usecase.command.show.ShowInput;

public class TaskController extends BaseController<ITaskModel> implements ITaskController {

    private final IShowUsecase showUsecase;
    private final IQuitUsecase quitUsecase;
    private final IAddProjectUsecase addProjectUsecase;
    private final IAddTaskUsecase addTaskUsecase;
    private final ICheckUsecase checkUsecase;
    private final IShowPresenter showPresenter;
    private final IQuitPresenter quitPresenter;

    public enum Type {
        QUIT,
        ADD,
        CHECK,
        UNCHECK,
        SHOW,
        HELP,
    }

    public enum AddType {
        PROJECT,
        TASK,
    }

    public TaskController(ITaskModel model,
            IShowUsecase showUsecase, IShowPresenter showPresenter,
            IQuitUsecase quitUsecase, IQuitPresenter quitPresenter,
            IAddProjectUsecase addProjectUsecase,
            IAddTaskUsecase addTaskUsecase,
            ICheckUsecase checkUsecase) {
        super(model);
        this.showUsecase = showUsecase;
        this.quitUsecase = quitUsecase;
        this.addProjectUsecase = addProjectUsecase;
        this.addTaskUsecase = addTaskUsecase;
        this.showPresenter = showPresenter;
        this.quitPresenter = quitPresenter;
        this.checkUsecase = checkUsecase;
    }

    @Override
    public void execute(String commandLine) {
        String command = commandLine.split(" ", 2)[0];
        String[] commandRest = commandLine.split(" ", 2);

        try {
            switch (Type.valueOf(command.toUpperCase())) {
                case QUIT:
                    quitPresenter.present(
                            quitUsecase.execute(
                                    new QuitInput()).getResult());
                    break;
                case ADD:
                    String[] typeRest = commandRest[1].split(" ", 2);
                    switch (AddType.valueOf(typeRest[0].toUpperCase())) {
                        case PROJECT:
                            addProjectUsecase.execute(new AddProjectInput(typeRest[1]));
                            break;
                        case TASK:
                            addTaskUsecase.execute(new AddTaskInput(
                                    typeRest[1].split(" ", 2)[0],
                                    typeRest[1].split(" ", 2)[1]));
                            break;
                        default:
                    }
                    break;
                case CHECK:
                    checkUsecase.execute(
                            new CheckInput(Long.parseLong(commandRest[1]), true));
                    break;
                case UNCHECK:
                    checkUsecase.execute(
                            new CheckInput(Long.parseLong(commandRest[1]), false));
                    break;
                case SHOW:
                    showPresenter.present(
                            showUsecase.execute(
                                    new ShowInput()).getResult());
                    break;
                case HELP:
                    this.model.getHelp();
                    break;
            }
        } catch (Exception e) {
            this.model.getUnknown(command);
        }
    }
}
