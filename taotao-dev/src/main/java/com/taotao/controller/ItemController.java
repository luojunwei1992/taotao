package com.taotao.controller;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import com.taotao.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;


/**
 * Created by comma on 16/11/16.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){

       TbItem tbItem =  itemService.getItemById(itemId);

        System.out.print("hello world");

        System.out.print("item");

        return tbItem;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1")Integer page,
                                    @RequestParam(defaultValue = "30")Integer rows)throws Exception{

        EasyUIResult result = itemService.getItemList(page,rows);

        return result;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(TbItem item,String desc,String itemParams){

        TbItemDesc itemDesc = new TbItemDesc();

        itemDesc.setItemDesc(desc);

        TaotaoResult result = itemService.addItem(item, itemDesc,itemParams);

        return result;
    }


}
