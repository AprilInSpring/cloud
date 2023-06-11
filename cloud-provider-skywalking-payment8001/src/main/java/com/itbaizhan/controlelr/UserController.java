package com.itbaizhan.controlelr;

import com.itbaizhan.entity.User;
import com.itbaizhan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户控制层
 */
@RequestMapping("user")
@RestController
public class UserController {


    @Autowired
    private IUserService iUserService;

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("findByAll")
    public List<User> getUser(){
        return iUserService.getUser();
    }


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("findById")
    public User findById(Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return iUserService.findById(id);
    }

}
