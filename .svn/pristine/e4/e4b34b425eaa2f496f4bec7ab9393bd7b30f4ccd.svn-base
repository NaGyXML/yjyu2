package com.yangjiayu.controller;

import com.yangjiayu.entity.Product;
import com.yangjiayu.service.IProductService;
import com.yangjiayu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 86188 on 2019/8/21.
 */
@RestController
@RequestMapping("product")
public class ProductController extends  BaseController {

    @Autowired
    IProductService iProductService;

    @RequestMapping("hotList")
    public JsonResult<List<Product>> hotList(){

        List<Product> allHot = iProductService.findALLHot();
        return  new JsonResult<List<Product>>(SUCCESS,allHot);
    }

    @RequestMapping("{id}/byId")
    public  JsonResult byId(Integer id){
        Product product = iProductService.SelectId(id);
        return  new JsonResult(SUCCESS,product);
    }

}
