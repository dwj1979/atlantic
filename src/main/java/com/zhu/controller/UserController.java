package com.zhu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhu.dao.UserMapper;
import com.zhu.po.User;
import com.zhu.po.UserExample;
import com.zhu.tool.GeneralKeyTool;

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