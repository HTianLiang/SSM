package com.tl.service;

import com.tl.pojo.QueryVo;
import com.tl.pojo.TUser;
import org.apache.ibatis.annotations.Param;

public interface TUserService {

	//通过用户名与密码验证
	public TUser selectByNameAndPass(@Param("userCode") String userCode, @Param("userPwd") String userPwd);

}
