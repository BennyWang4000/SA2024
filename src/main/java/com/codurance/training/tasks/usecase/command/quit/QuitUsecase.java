package com.codurance.training.tasks.usecase.command.quit;

import com.codurance.training.tasks.usecase.ITaskRepository;
import com.codurance.training.tasks.usecase.command.BaseTaskOperation;

public class QuitUsecase extends BaseTaskOperation<ITaskRepository> implements IQuitUsecase {

    public QuitUsecase(ITaskRepository repository) {
        super(repository);
    }

    @Override
    public QuitOutput execute(QuitInput input) {
        return null;
    }

}
