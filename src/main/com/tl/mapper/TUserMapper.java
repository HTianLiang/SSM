package com.tl.mapper;

import com.tl.pojo.QueryVo;
import com.tl.pojo.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    //通过用户名与密码验证
    TUser selectByNameAndPass(@Param("userCode") String userCode, @Param("userPwd") String userPwd);
    //显示用户全部信息
    List<TUser> selectCustomerListByQueryVo(QueryVo vo);
    //查询总条数
    Long selectCountByQueryVo(QueryVo vo);
}