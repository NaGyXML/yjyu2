package com.yangjiayu.service.ex;

/**
 * Created by 86188 on 2019/8/15.
 */
public class FileUploadIOException extends FileUploadException {

    private static final long serialVersionUID = 608205293789110407L;

    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    public FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
