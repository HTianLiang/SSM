package com.tl.mapper;

import com.tl.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {

    //显示查询条件内容
    public List<BaseDict> selectBaseDictByCode(String code);

}
