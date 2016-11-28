package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemService;
import com.taotao.utils.ExceptionUtil;
import com.taotao.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by comma on 16/11/16.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private  TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    public TbItem getItemById(long itemId) {

        System.out.print("itemservice");

        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);

        return item;
    }

    public EasyUIResult getItemList(Integer page, Integer rows) {

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(page,rows);

        List<TbItem> list = tbItemMapper.selectByExample(example);

        PageInfo pageInfo =  new PageInfo(list);

        Long total = pageInfo.getTotal();

        EasyUIResult easyUIResult = new EasyUIResult(total,list);

        return easyUIResult;
    }

    public TaotaoResult addItem(TbItem item, TbItemDesc itemDesc,String itemParams) {

        try {
            long itemId = IDUtils.genItemId();

            item.setId(itemId);
            item.setStatus((byte)1);

            Date date = new Date();
            item.setCreated(date);
            item.setUpdated(date);

            //把数据插入商品表
            tbItemMapper.insert(item);

            //添加商品描述
            itemDesc.setItemId(itemId);
            itemDesc.setUpdated(date);
            itemDesc.setCreated(date);
            tbItemDescMapper.insert(itemDesc);

            insertItemParamItem(itemId,itemParams);

        } catch (Exception e) {
            e.printStackTrace();

            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }


        return TaotaoResult.ok();
    }


    public TaotaoResult insertItemParamItem(Long itemId, String itemParam){

        TbItemParamItem itemParamItem = new TbItemParamItem();

        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());

        itemParamItemMapper.insert(itemParamItem);

        return TaotaoResult.ok();
    }

}
