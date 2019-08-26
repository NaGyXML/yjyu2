package com.yangjiayu.service.impl;

import com.yangjiayu.entity.User;
import com.yangjiayu.mapper.UserMapper;
import com.yangjiayu.service.IUserService;
import com.yangjiayu.service.ex.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 86188 on 2019/8/9.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void reg(User user) {
        //获取注册用户提交的用户名
        String username = user.getUsername();
        //查找数据库是否有对应数据
        System.out.println(username + "username+reg");
        User allByUsername = userMapper.findAllByUsername(username);
        //有  则注册失败   抛出异常
        if (allByUsername != null) {
            throw new UsernameConflictException("用户名已被占用(" + username + ")");
        }
        System.out.println(allByUsername);

        //数据库中无重复用户名
        //补全数据
        //补全盐值
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        //执行密码加密   在本类中添加私有方法来执行密码加密
        String md5password = getmd5Password(user.getPassword(), salt);
        //补全加密密码
        user.setPassword(md5password);
        //补全delete
        user.setIsDelete(0);
        //补全四项日志
        user.setCreatedUser(username);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedUser(username);
        user.setModifiedTime(date);
        //插入数据库
        System.out.println(user);
        Integer insert = userMapper.insert(user);
        //判断是否插入成功
        if (insert != 1) {
            throw new InsertException("注册过程中出现未知错误! 请联系管理员");
        }
        System.out.println("注册完成");

    }

    @Override
    public void updatePassword(HttpSession session, String oldPassword, String newPassword) {
        //通过sesson对象获取UID 和username
        Integer uid = (Integer) session.getAttribute("uid");
        String username = (String) session.getAttribute("username");
        //先根据当前id查询用户数据  判断得出结果
        User user = userMapper.findAllByUid(uid);
        System.out.println(user);
        //结果是null  或者 结果状态异常 如isdelete为删除状态 抛出异常
        if (user == null || user.getIsDelete() == 1) throw new UserNotFoundException("用户名不存在");
        //结果非空  则进行修改密码操作

        //修改密码
        //获取数据
        //获取盐值
        String salt = user.getSalt();
        //进行加密原密码
        String oldmd5password = getmd5Password(oldPassword, salt);
        //获得数据密码
        String password = user.getPassword();
        //判断原密码和数据密码是否相同
        if (!oldmd5password.equals(password)) throw new PasswordNotMatchException("原密码输入不正确");
        //否 抛出异常

        //是  将新密码加密
        String newmd5password = getmd5Password(newPassword, salt);
        //对数据库进行修改密码操作
        Integer integer = userMapper.updateByUid(uid, newmd5password, username, new Date());
        if (integer != 1) {
            throw new UpdateException("修改密码出现未知错误!请联系管理员");
        }
    }

    @Override
    public void updateAvatar(String url, Integer uid, String username) {
        //根据用户id判断用户状态是否正常
        User allByUid = userMapper.findAllByUid(uid);
        if (allByUid == null || allByUid.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户不存在");
        }
        //补全用户数据
        User user = new User();
        user.setUid(uid);
        user.setAvatar(url);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        //更新用户资料
        System.out.println(user);
        Integer integer = userMapper.updateAvatar(user);
        //判断是否更新成功
        if (integer != 1) {
            throw new UpdateException("修改用户头像时发生未知错误!请联系管理员");
        }
    }

    @Override
    public void updateUser(User user, Integer uid, String username) {
        user.setUid(uid);
        user.setUsername(username);
        Integer integer = userMapper.updateUser(user);
        if (integer != 1) {
            throw new UpdateException("修改个人资料时出现未知错误!请联系管理员");
        }

    }

    @Override
    public User findById(Integer id) {
        //查找数据
        User user = userMapper.findAllByUid(id);
        //判断是否返回数据
        if (user == null || user.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        //返回数据状态是否正确
        user.setCreatedTime(null);
        user.setCreatedTime(null);
        user.setSalt(null);
        user.setPassword(null);
        //过滤数据
        //返回用户数据
        return user;
    }

    @Override
    public User login(String username, String password) {
        //通过用户输入的用户名 密码判断登陆
        //通过用户名获取用户数据
        String name = username;
        String pass = password;
        User allByUsername = userMapper.findAllByUsername(name);
        //判断是否为空 或者 删除状态是否为已删除
        System.out.println("all:::::" + allByUsername);
        if ((allByUsername == null) || allByUsername.getIsDelete().equals(1))
            throw new UserNotFoundException("用户名输入错误!");
        //获取盐值
        String salt = allByUsername.getSalt();
        //获取数据密码
        String password1 = allByUsername.getPassword();
        String getmd5Password = getmd5Password(pass, salt);
        if (!password1.equals(getmd5Password)) throw new PasswordNotMatchException("密码输入错误!");
        allByUsername.setPassword(null);
        allByUsername.setSalt(null);
        allByUsername.setIsDelete(null);

        //将用户输入的密码进行加密 后对比数据中的密码  判断是否相同
        return allByUsername;
    }


    private String getmd5Password(String password, String salt) {
        String str = salt + password + salt;
        for (int i = 0; i < 3; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes());
        }
        return str;
    }


}
