package com.taotao.service;

import com.taotao.pojo.EasyUIResult;
import com.taotao.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by luo on 16/11/24.
 */
public interface ItemParamService {

    TaotaoResult getItemParamByCid(long cid);

    TaotaoResult insertItemParam(TbItemParam itemParam);

    EasyUIResult getItemParamList(Integer page,Integer rows);

}
