package com.yangjiayu.service;

import com.yangjiayu.entity.User;
import com.yangjiayu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by 86188 on 2019/8/8.
 */
public interface IUserService {
    /**
     * 用户登录
     * @param username 输入用户名
     * @param password 输入密码
     * @return 返回用户可视数据
     */
    User login(String username,String password);

    /**
     * 用户注册
     * @param user 用户注册填入数据
     */
    void reg(User user);

    /**
     * 修改密码
     * @param session 对应session对象
     * @param oldPassword 输入原密码
     * @param newPassword 输入新密码
     */
    void updatePassword(HttpSession session,String oldPassword,String newPassword);

    /**
     *
     * @param url
     * @param uid
     * @param username
     */
    void  updateAvatar(String url,Integer uid,String username);

    /**
     * 修改用户资料
     * @param user 存储新的用户数据的user对象
     * @param uid  用户id
     * @param username 用户名
     */
    void  updateUser(User user,Integer uid,String username);

    /**
     * 根据用户id 查找用户数据
     * @param id 用户id
     * @return  对应用户数据
     */
    User findById(Integer id);


}
