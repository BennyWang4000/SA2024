// package com.codurance.training.tasks.adapter.presenter;

// import com.codurance.training.base.adapter.BasePresenter;
// import com.codurance.training.base.usecase.port.cqrs.BaseCqrsOutput;
// import com.codurance.training.tasks.adapter.controller.ITaskController;
// import com.codurance.training.tasks.adapter.response.TaskOutput;
// import com.codurance.training.tasks.usecase.command.show.ShowDto;
// import com.codurance.training.tasks.view.CommandCallback;

// public class ShowPresenter extends BasePresenter<CommandCallback> implements
// ITaskPresenter {

// public ShowPresenter(CommandCallback callback, ITaskController controller) {
// super(callback);
// }

// @Override
// public void present(ShowDto showDto) {
// switch (output.getType()) {
// case SUCCESS:
// callback.onSuccess(output.getResult());
// break;
// case FAILURE:
// callback.onFailure(output.getResult());
// break;
// case QUIT:
// callback.onQuit();
// break;
// case ERROR:
// callback.onError(output.getError());
// break;
// case EMPTY:
// break;
// }
// }

// }