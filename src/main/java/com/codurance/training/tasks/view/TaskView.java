package com.codurance.training.tasks.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.codurance.training.tasks.adapter.controller.TaskController;
import com.codurance.training.base.view.BaseView;
import com.codurance.training.tasks.adapter.controller.ITaskController;
import com.codurance.training.tasks.adapter.presenter.IAddProjectPresenter;
import com.codurance.training.tasks.adapter.presenter.IQuitPresenter;
import com.codurance.training.tasks.adapter.presenter.IShowPresenter;
import com.codurance.training.tasks.usecase.ITaskModel;
import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.TaskModel;
import com.codurance.training.tasks.usecase.TaskRepository;
import com.codurance.training.tasks.usecase.command.quit.IQuitUsecase;
import com.codurance.training.tasks.usecase.command.quit.QuitUsecase;
import com.codurance.training.tasks.usecase.command.add.IAddProjectUsecase;
import com.codurance.training.tasks.usecase.command.add.AddProjectUsecase;
import com.codurance.training.tasks.usecase.command.add.IAddTaskUsecase;
import com.codurance.training.tasks.usecase.command.check.CheckUsecase;
import com.codurance.training.tasks.usecase.command.check.ICheckUsecase;
import com.codurance.training.tasks.usecase.command.add.AddTaskUsecase;
import com.codurance.training.tasks.usecase.command.quit.CommandDto;
import com.codurance.training.tasks.usecase.command.show.IShowUsecase;
import com.codurance.training.tasks.usecase.command.show.ProjectDto;
import com.codurance.training.tasks.usecase.command.show.ProjectsDto;
import com.codurance.training.tasks.usecase.command.show.TaskDto;
import com.codurance.training.tasks.usecase.command.show.ShowUsecase;

public final class TaskView extends BaseView implements ITaskView {

    private boolean isRunning = true;

    private final ITaskController controller;

    public TaskView(BufferedReader reader, PrintWriter writer) {
        super(reader, writer);

        ITaskModel model = new TaskModel();

        ITaskRepository repository = new TaskRepository();

        IShowUsecase showUsecase = new ShowUsecase(repository);
        IQuitUsecase quitUsecase = new QuitUsecase(repository);
        IAddProjectUsecase addProjectUsecase = new AddProjectUsecase(repository);
        IAddTaskUsecase addTaskUsecase = new AddTaskUsecase(repository);
        ICheckUsecase checkUsecase = new CheckUsecase(repository);

        IQuitPresenter quitPresenter = new IQuitPresenter() {
            @Override
            public void present(CommandDto dto) {
                System.out.println("CALLBACK COULD WORK.");
                isRunning = false;
            }
        };

        IShowPresenter showPresenter = new IShowPresenter() {
            @Override
            public void present(ProjectsDto projectsDto) {
                System.out.println("CALLBACK COULD WORK.");
                for (ProjectDto projectDto : projectsDto.getProjectDtos()) {
                    writer.println(projectDto.getProjectName());
                    for (TaskDto taskDto : projectDto.getTaskDtos()) {
                        writer.println(String.format("    [%c] %d: %s",
                                taskDto.isDone() ? 'x' : ' ',
                                taskDto.getId(),
                                taskDto.getDescription()));
                    }
                    writer.println();
                }
            }
        };

        this.controller = new TaskController(model,
                showUsecase, showPresenter,
                quitUsecase, quitPresenter,
                addProjectUsecase,
                addTaskUsecase,
                checkUsecase);
    }

    @Override
    public void run() {
        while (isRunning) {
            writer.print("> ");
            writer.flush();
            String command;
            try {
                command = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.controller.execute(command);
        }
    }
}
