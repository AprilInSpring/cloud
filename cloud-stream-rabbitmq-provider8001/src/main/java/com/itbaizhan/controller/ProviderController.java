package com.itbaizhan.controller;

import com.itbaizhan.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private IMessageProvider iMessageProvider;


    /**
     * 发送消息
     * @param message 消息内容
     * @return
     */
    @GetMapping("send")
    public String send(String message){
       return  iMessageProvider.send(message);
    }




    /**
     * 发送分组消息
     * @param message 消息内容
     * @return
     */
    @GetMapping("groupsend")
    public String groupsend(String message){
        return  iMessageProvider.groupSend(message);
    }


}
