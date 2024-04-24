package com.codurance.training.base.usecase.port.cqrs;

import com.codurance.training.base.usecase.port.BaseOutput;

public class BaseCommandOutput<O extends BaseCommandOutput<O>> implements BaseOutput {

    protected ResultType type;
    protected String message = "";

    public String getMessage() {
        return message;
    }

    @SuppressWarnings("unchecked")
    public O setMessage(String message) {
        this.message = message;
        return (O) this;
    }

    protected BaseCommandOutput() {
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

    // public static BaseCommandOutput fail(String result) {
    // return new Failure(result);
    // }

    // public static BaseCommandOutput error(Throwable result) {
    // return new Error(result);
    // }

    // @Override
    // public ResultType getType() {
    // return type;
    // }

    // public static final class Success extends BaseCommandOutput {
    // protected Success() {
    // this.type = ResultType.SUCCESS;
    // }
    // }

    // public static final class Failure extends BaseCommandOutput {

    // protected Failure(String result) {
    // this.type = ResultType.FAILURE;
    // }

    // public getResult()
    // }

    // public static final class Error extends BaseCommandOutput {
    // protected Error(Throwable throwable) {
    // this.type = ResultType.ERROR;
    // }
    // }
}
