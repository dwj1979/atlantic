package com.zhu.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhu.dao.UserMapper;
import com.zhu.po.User;

@RestController
public class UserController {

	@Resource
	UserMapper userMapper;

	@RequestMapping("/adduser/{username}/{psd}")
	public String add(@PathVariable String username) {
		return null;
	}

	@RequestMapping("/finduser/{username}")
	public User find(@PathVariable String username) {
		return null;
	}
}