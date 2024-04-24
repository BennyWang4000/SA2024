package com.codurance.training.tasks.adapter.response;

public abstract class TaskResult<T> {

    public enum ResultType {
        SUCCESS,
        FAILURE,
        QUIT,
        EMPTY,
        ERROR,
    }

    public T getResult() {
        return null;
    }

    public String getFailure() {
        return null;
    }

    public Throwable getError() {
        return null;
    }

    public static <T> TaskResult<T> success(T result) {
        return new Success<>(result);
    }

    public static <T> TaskResult<T> fail(String result) {
        return new Failure<>(result);
    }

    public static <T> TaskResult<T> error(Throwable result) {
        return new Error<>(result);
    }

    public static <T> TaskResult<T> quit() {
        return new Quit<>();
    }

    public static <T> TaskResult<T> empty() {
        return new Empty<>();
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

        @Override
        public String getFailure() {
            return result;
        }

        public ResultType getType() {
            return ResultType.FAILURE;
        }
    }

    public static final class Quit<T> extends TaskResult<T> {

        protected Quit() {
        }

        public ResultType getType() {
            return ResultType.QUIT;
        }
    }

    public static final class Empty<T> extends TaskResult<T> {

        protected Empty() {
        }

        public ResultType getType() {
            return ResultType.EMPTY;
        }
    }

    public static final class Error<T> extends TaskResult<T> {
        private final Throwable throwable;

        protected Error(Throwable error) {
            this.throwable = error;
        }

        @Override
        public Throwable getError() {
            return throwable;
        }

        public ResultType getType() {
            return ResultType.ERROR;
        }
    }
}
