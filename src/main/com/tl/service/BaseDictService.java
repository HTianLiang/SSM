package com.tl.service;

import com.tl.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    //查询
    public List<BaseDict> selectBaseDictByCode(String code);

}
