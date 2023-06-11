package com.itbaizhan.service.impl;

import com.itbaizhan.entity.User;
import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.service.IUserService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部用户
     * @return
     */
    @Trace
    @Override
    public List<User> getUser() {
        return userMapper.selectList(null);
    }

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return
     */
    @Trace
    @Override
    public User findById(Long id) {
        return userMapper.selectById(id);
    }
}
