package com.taotao.controller;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by luo on 16/11/24.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;


    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemParamList(@RequestParam(defaultValue = "1")Integer page,
                                         @RequestParam(defaultValue = "30")Integer rows){

        EasyUIResult list = itemParamService.getItemParamList(page, rows);

        return list;

    }

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){

        TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);

        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public  TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){

        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        TaotaoResult taotaoResult = itemParamService.insertItemParam(itemParam);


        return taotaoResult;
    }
}
