package com.taotao.controller;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by comma on 16/11/16.
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){

       TbItem tbItem =  itemService.getItemById(itemId);

        System.out.print("hello world");

        System.out.print("item");

        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1")Integer page,
                                    @RequestParam(defaultValue = "30")Integer rows)throws Exception{

        EasyUIResult result = itemService.getItemList(page,rows);

        return result;
    }

}
