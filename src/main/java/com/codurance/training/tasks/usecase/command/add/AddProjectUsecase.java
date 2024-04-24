package com.codurance.training.tasks.usecase.command.add;

import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.command.BaseTaskOperation;

public class AddProjectUsecase extends BaseTaskOperation<ITaskRepository> implements IAddProjectUsecase {

    public AddProjectUsecase(ITaskRepository repository) {
        super(repository);
    }

    @Override
    public AddOutput execute(AddProjectInput input) {
        repository.getProjects().addProject(
                new ProjectName(input.getName()));

        return new AddOutput().succeed();
    }
}
