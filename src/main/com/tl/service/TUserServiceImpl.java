package com.tl.service;

import com.tl.mapper.TUserMapper;
import com.tl.pojo.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserServiceImpl implements TUserService {
	
	@Autowired
	private TUserMapper userMapper;

	//通过用户名与密码验证
	@Override
	public TUser selectByNameAndPass(@Param("userCode")String userCode, @Param("userPwd")String userPwd){
		System.err.println("验证用户名和密码");
		TUser user = userMapper.selectByNameAndPass(userCode,userPwd);
		return user;
	}

}
