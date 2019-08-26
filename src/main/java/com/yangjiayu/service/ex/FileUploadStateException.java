package com.yangjiayu.service.ex;

/**
 * Created by 86188 on 2019/8/15.
 */

/**
 * 上传文件状态异常,可能文件已被移动无法找到
 */
public class FileUploadStateException extends  FileUploadException {
    private static final long serialVersionUID = -521983025848883680L;

    public FileUploadStateException() {
    }

    public FileUploadStateException(String message) {
        super(message);
    }

    public FileUploadStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadStateException(Throwable cause) {
        super(cause);
    }

    public FileUploadStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
