package com.yangjiayu.service.ex;

/**
 * Created by 86188 on 2019/8/14.
 */
public class UpdateException extends ServiceException {

    private static final long serialVersionUID = 4495706903084876749L;

    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
