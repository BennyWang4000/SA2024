package com.codurance.training.base.usecase.port.cqrs;

import com.codurance.training.base.usecase.port.BaseOutput;

public abstract class BaseQueryOutput<D, O extends BaseQueryOutput<D, O>> implements BaseOutput {

    protected ResultType type;

    protected D dto;

    public void setResult(D dto) {
        this.dto = dto;
    }

    public D getResult() {
        return this.dto;
    }

    protected BaseQueryOutput() {
        this.type = ResultType.SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public O succeed() {
        this.type = ResultType.SUCCESS;
        return (O) this;
    }

    @SuppressWarnings("unchecked")
    public O fail() {
        this.type = ResultType.FAILURE;
        return (O) this;
    }

    @SuppressWarnings("unchecked")
    public O error() {
        this.type = ResultType.ERROR;
        return (O) this;
    }

    public ResultType getType() {
        return type;
    }
}
