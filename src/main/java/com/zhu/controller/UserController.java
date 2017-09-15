package com.zhu.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhu.dao.UserInfoMapper;
import com.zhu.dao.UserMapper;
import com.zhu.po.User;
import com.zhu.po.UserInfo;
import com.zhu.tool.GeneralKeyTool;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Resource
	UserMapper userMapper;
	@Resource
	UserInfoMapper userInfoMapper;

	@RequestMapping("/user/add")
	@Transactional
	public String add(@RequestBody Map<String, String> param) {
		try {
			String uid = GeneralKeyTool.getId().substring(0,5)+((String)param.get("uname")).hashCode();
			User user = new User();
			user.setComment(param.get("comment"));
			user.setId(GeneralKeyTool.getId().substring(0,19));
			user.setUserName(param.get("uname"));
			user.setUserPsd(param.get("pswd"));
			user.setUserId(uid);
			user.setCtime(new Date());
			userMapper.insertSelective(user);
			UserInfo userInfo = new UserInfo();
			userInfo.setAddr(param.get("addr"));
			userInfo.setGender(Integer.parseInt(param.get("gender")));
			userInfo.setPhone(Long.parseLong(param.get("phone")+""));
			userInfo.setUserId(uid);
			userInfo.setCtime(new Date());
			userInfoMapper.insertSelective(userInfo );
			System.out.println("******************************");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "fail";
		}
	}

	@RequestMapping("/finduser/{username}")
	public User find(@PathVariable String username) {
		return null;
	}
}