package com.yangjiayu.service;

import com.yangjiayu.entity.Product;

import java.util.List;

/**
 * Created by 86188 on 2019/8/21.
 * 處理商品信息的業務層接口
 */
public interface IProductService {

    /**
     * 查找Hot商品
     * @return Hot商品集合
     */
    List<Product> findALLHot();

    /**
     * 根据商品id查找对应商品信息
     * @param id 商品id
     * @return 封装商品信息的对象
     */
    Product SelectId(Integer id);
}
