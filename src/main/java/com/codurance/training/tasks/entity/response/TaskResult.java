package com.codurance.training.tasks.entity.response;

public abstract class TaskResult<T> {

    public enum ResultType {
        SUCCESS,
        FAILURE,
        EMPTY,
        ERROR,
        QUIT
    }

    public T getResult() {
        return null;
    }

    public static <T> TaskResult<T> success(T result) {
        return new Success<>(result);
    }

    public static <T> TaskResult<T> fail(String result) {
        return new Failure<>(result);
    }

    public static <T> TaskResult<T> empty() {
        return new Empty<>();
    }

    public static <T> TaskResult<T> quit() {
        return new Quit<>();
    }

    public static <T> TaskResult<T> error(Throwable result) {
        return new Error<>(result);
    }

    public abstract ResultType getType();

    public static final class Success<T> extends TaskResult<T> {
        private final T result;

        protected Success(T result) {
            this.result = result;
        }

        @Override
        public T getResult() {
            return result;
        }

        public ResultType getType() {
            return ResultType.SUCCESS;
        }
    }

    public static final class Failure<T> extends TaskResult<T> {
        private final String result;

        protected Failure(String result) {
            this.result = result;
        }

        public String getFailure() {
            return result;
        }

        public ResultType getType() {
            return ResultType.FAILURE;
        }
    }

    public static final class Empty<T> extends TaskResult<T> {

        protected Empty() {
        }

        public ResultType getType() {
            return ResultType.EMPTY;
        }
    }

    public static final class Quit<T> extends TaskResult<T> {

        protected Quit() {
        }

        public ResultType getType() {
            return ResultType.QUIT;
        }
    }

    public static final class Error<T> extends TaskResult<T> {
        private final Throwable error;

        protected Error(Throwable error) {
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
