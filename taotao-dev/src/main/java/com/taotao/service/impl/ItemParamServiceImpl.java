package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by luo on 16/11/24.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    public TaotaoResult getItemParamByCid(long cid) {

        TbItemParamExample example = new TbItemParamExample();

        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

        if (list!= null && list.size() > 0){

            return TaotaoResult.ok(list.get(0));
        }

        return TaotaoResult.ok();
    }

    public TaotaoResult insertItemParam(TbItemParam itemParam) {

        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());

        itemParamMapper.insert(itemParam);

        return TaotaoResult.ok();
    }

    public EasyUIResult getItemParamList(Integer page, Integer rows) {

        TbItemParamExample example = new TbItemParamExample();


        PageHelper.startPage(page,rows);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

        PageInfo pageInfo = new PageInfo(list);

        long total = pageInfo.getTotal();

        EasyUIResult easyUIResult = new EasyUIResult(total, list);

        return easyUIResult;
    }


}
