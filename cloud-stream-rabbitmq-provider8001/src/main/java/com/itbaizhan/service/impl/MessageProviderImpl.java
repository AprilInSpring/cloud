package com.itbaizhan.service.impl;

import com.itbaizhan.common.MyMessage;
import com.itbaizhan.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

/**
 * 定义消息的推送的管道
 */
@Service
public class MessageProviderImpl  implements IMessageProvider {



    //直接装配桥  用来连接rabbitmq 或者kafka
    @Autowired
    StreamBridge streamBridge;

    @Override
    public String send(String message) {

        MyMessage myMessage = new MyMessage();
        myMessage.setPayload(message);

        /**
         * 第一个参数： 绑定的名称 格式为  自定义的绑定名称-out-0
         * 第二个参数： 发送消息实体
         */
        streamBridge.send("myBroadcat-out-0",myMessage);

        return "success";
    }

    @Override
    public String groupSend(String message) {

        MyMessage myMessage = new MyMessage();
        myMessage.setPayload(message);

        /**
         * 第一个参数： 绑定的名称 格式为  自定义的绑定名称-out-0
         * 第二个参数： 发送消息实体
         */
        streamBridge.send("myGroup-out-0",myMessage);

        return "success";
    }

}
