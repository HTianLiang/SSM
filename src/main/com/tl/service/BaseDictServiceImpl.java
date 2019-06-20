package com.tl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tl.mapper.BaseDictMapper;
import com.tl.pojo.BaseDict;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    //显示查询条件内容
    @Override
    public List<BaseDict> selectBaseDictByCode(String code) {
        return baseDictMapper.selectBaseDictByCode(code);
    }
}
