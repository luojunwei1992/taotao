package com.taotao.service;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TbItem;

/**
 * Created by comma on 16/11/16.
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EasyUIResult getItemList(Integer page, Integer rows);
}
