package com.yangjiayu.controller;

import com.yangjiayu.entity.User;
import com.yangjiayu.service.IUserService;
import com.yangjiayu.service.ex.*;
import com.yangjiayu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 86188 on 2019/8/8.
 */

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    final int FILESZ = 1000000;
    final String FILETYPE = "image";
    @Autowired
    public IUserService iUserService;

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        System.out.println("登陆用户名:" + username + "; 登陆密码:" + password);
        User user = iUserService.login(username, password);
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        return new JsonResult(SUCCESS, user);
    }

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        System.out.println(user + "-----------reguser");
        iUserService.reg(user);
        return new JsonResult<>(SUCCESS);
    }

    @RequestMapping("password")
    public JsonResult updatePassword(String oldPassword, String newPassword, HttpSession session) {
        iUserService.updatePassword(session, oldPassword, newPassword);
        return new JsonResult(SUCCESS);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> findById(HttpSession session, User user) {
        Integer uid = getUid(session);
        User byId = iUserService.findById(uid);
        return new JsonResult<>(SUCCESS,byId);
    }

    @RequestMapping("down")
    public void down(HttpSession session){
        session.removeAttribute("udi");
        session.removeAttribute("username");
    }

    @PostMapping("avatar")
    public JsonResult<String> avatar(HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            throw  new FileUploadException("没有上传文件或者上传文件为0字节");
        }


        if (file.getContentType().indexOf(FILETYPE)<1){
            throw new FileTypeException("上传文件类型出错");
        }


        if (file.getSize()> FILESZ){
            throw  new FileSizeException("上传文件大小太大");
        }
        String upload = request.getServletContext().getRealPath("upload");
        String originalFilename = file.getOriginalFilename();
        String substring ="";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex>0) {
            substring = originalFilename.substring(beginIndex);
        }
        File f = new File(upload);
        if (!f.exists()){
            f.mkdirs();
        }
        String s = UUID.randomUUID().toString();
            File file1 = new File(f, s + substring);
        try {
            file.transferTo(file1);
        }catch (IllegalStateException e){
            throw  new FileUploadStateException("上传文件状态异常,可能文件已被移动无法找到");
        }catch (IOException e) {
            e.printStackTrace();
            throw  new FileUploadIOException("出现读写异常");
        }
        Integer uid = getUid(session);
        String username = getUsername(session);
        String path =  "/upload/"+s+substring;
        iUserService.updateAvatar(path,uid,username);
        return  new JsonResult<String>(SUCCESS,path);
    }

    @RequestMapping("userdata")
    public void data(HttpSession session,User user){
        iUserService.updateUser(user,getUid(session),getUsername(session));
    }

  }
