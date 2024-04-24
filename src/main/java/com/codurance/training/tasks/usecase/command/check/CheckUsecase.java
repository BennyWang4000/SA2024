package com.codurance.training.tasks.usecase.command.check;

import com.codurance.training.tasks.entity.MessageService;
import com.codurance.training.tasks.entity.TaskId;
import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.command.BaseTaskOperation;

public class CheckUsecase extends BaseTaskOperation<ITaskRepository> implements ICheckUsecase {

    public CheckUsecase(ITaskRepository repository) {
        super(repository);
    }

    @Override
    public CheckOutput execute(CheckInput input) {

        TaskId taskId = new TaskId(input.getTaskId());

        if (!repository.getProjects().isTaskExist(taskId)) {
            return new CheckOutput()
                    .fail()
                    .setMessage(MessageService.getTaskNotFound(taskId.getId()));
        }

        repository.getProjects().check(taskId, input.isDone());

        return new CheckOutput().succeed();
    }
}
