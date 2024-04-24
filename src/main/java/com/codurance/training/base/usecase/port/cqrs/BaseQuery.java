package com.codurance.training.base.usecase.port.cqrs;

import com.codurance.training.base.usecase.BaseUsecase;
import com.codurance.training.base.usecase.port.BaseInput;
import com.codurance.training.base.usecase.port.BaseOutput;

public interface BaseQuery<D, I extends BaseInput, O extends BaseOutput> extends BaseUsecase<I, O> {

}
