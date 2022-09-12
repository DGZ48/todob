package xyz.dgz48.todob.common.exception;

public abstract class BusinessLogicException extends RuntimeException {

    public BusinessLogicException(String arg0) {
        super(arg0);
    }

    public BusinessLogicException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
