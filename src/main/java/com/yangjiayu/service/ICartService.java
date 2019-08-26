package com.yangjiayu.service;

import com.yangjiayu.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by 86188 on 2019/8/22.
 * 处理购物车业务的  业务层接口
 */
public interface ICartService {

    /**
     * 添加购物车数据
     * @param username 用户名
     * @param pid 商品id
     * @param uid 用户id
     * @param num 商品数量
     */
    void  insert(String username,Integer pid,Integer uid,Integer num);


}
