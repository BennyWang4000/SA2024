package com.codurance.training.tasks.usecase.command.add;

import com.codurance.training.tasks.entity.MessageService;
import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.command.BaseTaskOperation;

public class AddTaskUsecase extends BaseTaskOperation<ITaskRepository> implements IAddTaskUsecase {

    public AddTaskUsecase(ITaskRepository repository) {
        super(repository);
    }

    @Override
    public AddOutput execute(AddTaskInput input) {

        ProjectName projectName = new ProjectName(input.getProjectName());

        if (!repository.getProjects().isProjectExist(projectName)) {
            return new AddOutput()
                    .fail()
                    .setMessage(MessageService.getProjNotFound(projectName.getValue()));
        }

        repository.getProjects().addTask(projectName, input.getDescription());

        return new AddOutput().succeed();
    }
}
