package com.yangjiayu.mapper;

import com.yangjiayu.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by 86188 on 2019/8/22.
 * 购物车业务 持久层接口
 */
public interface CartMapper {
    /**
     * 添加购物车数据
     * @param cart 添加的数据对象
     * @return 影响数据库行数
     */
    Integer save(Cart cart);

    /**
     * 修改购物车数据
     * @param cid 购物车数据id
     * @param num 对应商品在数据库中的数量数量
     * @param modifiedUser 最后执行修改人
     * @param modifiedTime 最后执行修改时间
     * @return 影响数据行数
     */
    Integer updateNum(
            @Param("cid") Integer cid,
            @Param("num")Integer num,
            @Param("modifiedUser")String modifiedUser,
            @Param("modifiedTime")Date modifiedTime);

    /**
     * 根据用户id 商品id查找对应的购物车商品id
     * @param uid 用户id
     * @param pid 商品id
     * @return 对应购物车数据
     */
    Cart findByUidAndPid(
            @Param("uid")Integer uid,
            @Param("pid")Integer pid);
}
