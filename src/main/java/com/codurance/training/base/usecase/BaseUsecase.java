package com.codurance.training.base.usecase;

import com.codurance.training.base.usecase.port.BaseInput;
import com.codurance.training.base.usecase.port.BaseOutput;

public interface BaseUsecase<I extends BaseInput, O extends BaseOutput> {

    O execute(I input);
}