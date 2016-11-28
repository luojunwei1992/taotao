package com.taotao.service;

import com.taotao.pojo.TreeNode;

import java.util.List;

/**
 * Created by luo on 16/11/23.
 */
public interface ItemCatService {

    List<TreeNode> getItemCatList(long parentId);
}
