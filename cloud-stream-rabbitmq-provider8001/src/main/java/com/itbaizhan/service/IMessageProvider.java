package com.itbaizhan.service;

/**
 * 发送消息的接口
 */
public interface IMessageProvider {

    /**
     * 发送消息
     * @param message 消息内容
     * @return
     */
    String  send(String message);


    /**
     * 分组消费
     * @param message 消息内容
     * @return
     */
    String  groupSend(String message);
}
