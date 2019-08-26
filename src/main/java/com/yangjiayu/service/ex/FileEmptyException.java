package com.yangjiayu.service.ex;

/**
 * Created by 86188 on 2019/8/15.
 */

/**
 * 上传文件基类异常
 */
public class FileEmptyException  extends  FileUploadException{
    private static final long serialVersionUID = -4076178211654929439L;

    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
