package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by comma on 16/11/16.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

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
}
