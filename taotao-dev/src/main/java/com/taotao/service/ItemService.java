package com.taotao.service;

import com.taotao.pojo.*;

import java.util.List;

/**
 * Created by comma on 16/11/16.
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EasyUIResult getItemList(Integer page, Integer rows);

    TaotaoResult addItem(TbItem item, TbItemDesc itemDesc,String itemParams);

    TaotaoResult insertItemParamItem(Long itemId,String itemParam);

}
