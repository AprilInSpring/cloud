package com.itbaizhan.service;

import com.itbaizhan.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 查询全部用户
     * @return
     */
    List<User> getUser();


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Long id);
}
