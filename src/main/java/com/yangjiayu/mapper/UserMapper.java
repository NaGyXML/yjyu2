package com.yangjiayu.mapper;

import com.yangjiayu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by 86188 on 2019/8/8.
 */
public interface UserMapper {
    /**
     * 添加用户数据
     * @param user 用户数据
     * @return 数据库影响行数
     */
    Integer insert(User user);

    /**
     * 根据用户id修改用户资料
     * @param user 用户信息及需要修改的用户资料
     * @return 影响用户数据行数
     */
    Integer updateUser(User user);

    /**
     * 根据用户ID修改用户密码
     * @param uid 用户胡id
     * @return 影响数据库行数
     */
    Integer updateByUid(@Param("uid") Integer uid,
                        @Param("password")String password,
                        @Param("modifiedUser")String modifiedUser,
                        @Param("modifiedTime")Date modifiedTime);

    /**
     * 根据用户id查找用户数据
     * @param uid 用户id
     * @return 用户数据
     */
    User findAllByUid(Integer uid);

    /**
     * 根据用户名查找用户数据
     * @param username 用户名
     * @return 用户数据
     */
    User findAllByUsername(String username);

    /**
     * 修改用户头像
     * @param user 用户需要更新的数据
     * @return 影响数据行数
     */
    Integer updateAvatar(User user);
}
