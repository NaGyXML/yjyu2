package com.yangjiayu.service.impl;

import com.yangjiayu.entity.Cart;
import com.yangjiayu.mapper.CartMapper;
import com.yangjiayu.service.ICartService;
import com.yangjiayu.service.IProductService;
import com.yangjiayu.service.ex.InsertException;
import com.yangjiayu.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 86188 on 2019/8/22.
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    IProductService iProductService;

    @Override
    public void  insert(String username,Integer pid,Integer uid,Integer num) {
        // 根据参数uid和pid查询数据
        Cart result = findByUidAndPid(uid, pid);
        Date now = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 通过productService查出商品价格
            Long price = iProductService.SelectId(pid).getPrice();
            // 执行添加
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(num);
            cart.setPrice(price);
            cart.setCreatedUser(username);
            cart.setModifiedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedTime(now);
            save(cart);
        } else {
            // 从查询结果中获取原数量，和参数num相加，得到新数量
            Integer number = result.getNum() + num;
            // 执行更新数量
            updateNum(result.getCid(), number, username, now);
        }

    }


    
    /**
     * 添加购物车数据
     * @param cart 添加的数据对象
     */
    private void save(Cart cart){
        Integer save = cartMapper.save(cart);
        if (save!=1){
            throw  new InsertException("插入购物车数据时出现未知错误 !请联系管理员");
        }
    };
    /**
     * 修改购物车数据
     * @param cid 购物车数据id
     * @param num 对应商品在数据库中的数量数量
     * @param modifiedUser 最后执行修改人
     * @param modifiedTime 最后执行修改时间
     */
    private void updateNum(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
        Integer integer = cartMapper.updateNum(cid, num, modifiedUser, modifiedTime);
        if (integer!=1){
            throw  new UpdateException("修改购物车数据时出现未知错误!请联系管理员");
        }
    }
    /**
     * 根据用户id 商品id查找对应的购物车商品id
     * @param uid 用户id
     * @param pid 商品id
     * @return 对应购物车数据
     */
    private Cart findByUidAndPid(Integer uid, Integer pid) {
        return cartMapper.findByUidAndPid(uid, pid);
    }
}
