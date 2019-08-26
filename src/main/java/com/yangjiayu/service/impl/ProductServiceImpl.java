package com.yangjiayu.service.impl;

import com.yangjiayu.entity.Product;
import com.yangjiayu.mapper.ProductMapper;
import com.yangjiayu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 86188 on 2019/8/21.
 * 處理商品信息的業務層接口實現類
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findALLHot() {
        List<Product> hotList = productMapper.findHotList();
        hotList.forEach(o->{
            o.setCreatedTime(null);
            o.setCreatedUser(null);
            o.setModifiedTime(null);
            o.setModifiedUser(null);
            o.setPriority(null);
            o.setCategoryId(null);
        });
        return hotList;
    }

    @Override
    public Product SelectId(Integer id) {
        Product byId = productMapper.findById(id);
        byId.setCreatedTime(null);
        byId.setCreatedUser(null);
        byId.setModifiedTime(null);
        byId.setModifiedUser(null);
        byId.setPriority(null);
        byId.setCategoryId(null);
        return byId;
    }
}
