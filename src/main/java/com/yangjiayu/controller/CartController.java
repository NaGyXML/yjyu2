package com.yangjiayu.controller;

import com.yangjiayu.service.ICartService;
import com.yangjiayu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 86188 on 2019/8/22.
 */
@RestController
@RequestMapping("Cart")
public class CartController extends  BaseController {

    @Autowired
    ICartService iCartService;

    @RequestMapping("addCart")
    public JsonResult<Void> addToCart(HttpSession session,Integer pid,Integer num){

        Integer uid = getUid(session);
        String username = getUsername(session);
        iCartService.insert(username,pid,uid,num);
        return  new JsonResult<Void>(SUCCESS);
    }
}
