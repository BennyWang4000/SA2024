package com.codurance.training.base;

public abstract class BaseResult<T> {

    public enum ResultType {
        SUCCESS,
        FAILURE,
        EMPTY,
        ERROR,
        QUIT
    }

    static <T> BaseResult<T> onSuccess(T result) {
        return new Success<T>(result);
    }

    static <T> BaseResult<T> onFailure(String result) {
        return new Failure<T>(result);
    }

    public abstract ResultType getType();

    // public abstract T getResult();

    // public abstract String getError();

    public static class Success<T> extends BaseResult<T> {
        private final T result;

        public Success(T result) {
            this.result = result;
        }

        public T getResult() {
            return result;
        }

        public ResultType getType() {
            return ResultType.SUCCESS;
        }
    }

    public static final class Failure<T> extends BaseResult<T> {
        private final String result;

        public Failure(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }

        public ResultType getType() {
            return ResultType.FAILURE;
        }
    }

    public static final class Empty<T> extends BaseResult<T> {

        public Empty() {
        }

        public ResultType getType() {
            return ResultType.EMPTY;
        }
    }

    public static final class Quit<T> extends BaseResult<T> {

        public Quit() {
        }

        public ResultType getType() {
            return ResultType.QUIT;
        }
    }

    public static final class Error<T> extends BaseResult<T> {
        private final Throwable error;

        public Error(Throwable error) {
            this.error = error;
        }

        public Throwable getError() {
            return error;
        }

        public ResultType getType() {
            return ResultType.ERROR;
        }
    }
}
