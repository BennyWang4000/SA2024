package com.codurance.training.tasks.usecase.command.show;

import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.command.BaseTaskOperation;

public class ShowUsecase extends BaseTaskOperation<ITaskRepository> implements IShowUsecase {

    public ShowUsecase(ITaskRepository repository) {
        super(repository);
    }

    @Override
    public ShowOutput execute(ShowInput input) {
        ShowOutput showOutput = new ShowOutput();
        showOutput.setResult(ProjectsMapper.toDto(repository.getProjects()));
        return showOutput;
    }
}
