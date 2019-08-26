package com.yangjiayu.controller;

/**
 * Created by 86188 on 2019/8/12.
 */


import com.yangjiayu.service.ex.*;
import com.yangjiayu.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制器基类
 */
public class BaseController {

    /**
     * 响应成功的标识码
     */
    public static final int SUCCESS =200;

    /**
     * 用户名冲突异常的标识码,例如:注册时用户名被占用
     */
    public static final int USERNAME= 4000;
    /**
     * 用户名不存在的标识码,例如:登录时用户名输入错误
     */
    public static  final  int USERNAMENOT=4004;
    /**
     * 密码错误的标识码,例如:登录时密码输入错误
     */
    public static  final  int PASSNOT = 4030;
    /**
     * 数据库插入时异常的标识码
     */
    public static final int INSERT =5000;

    /**
     * 上传文件为空或者上传文件大小为0字节
     */
    public static  final  int FILEEM=6000;

    /**
     * 上传文件类型错误
     */
    public static final int FILETP=6050;

    /**
     * 上传文件大小过大
     */
    public static final int FILESZ=6075;

    /**
     * 文件上传异常 ,文件可能已经被移动或者被删除,不可访问到该文件
     */
    public static final int FILESTATE= 7050;

    /**
     * 文件读写异常
     */
    public static final int FILEIO=7000;
    @ExceptionHandler({ServiceException.class,FileEmptyException.class})
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> js=new JsonResult<>(e);
        if (e instanceof UsernameConflictException){
            js.setState(USERNAME);
        }else if (e instanceof InsertException){
            js.setState(INSERT);
        }else if (e instanceof PasswordNotMatchException){
            js.setState(PASSNOT);
        }else if(e instanceof UserNotFoundException){
            js.setState(USERNAMENOT);
        }else if(e instanceof FileEmptyException) {
            js.setState(FILEEM);
        }else if (e instanceof FileSizeException){
            js.setState(FILESZ);
        }else if (e instanceof  FileTypeException){
            js.setState(FILETP);
        } else if(e instanceof  FileUploadStateException){
            js.setState(FILESTATE);
        }else if (e instanceof  FileUploadIOException){
            js.setState(FILEIO);
        }

        return js;
    }
    /**
     * 根据session获取用户名
     * @param session 服务器session
     * @return 用户名字符串
     */
    public String getUsername(HttpSession session){
        return  session.getAttribute("username").toString();
    }

    /**
     * 根据session获取用户id
     * @param session 服务器session
     * @return 用户id integer
     */
    public  Integer getUid(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

}
