package com.itbaizhan.service;

import com.itbaizhan.common.MyMessage;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * 消息消费者
 */
@Component
@Slf4j
public class Concumer {


    /*
     * 消费广播消息
     */
    @Bean
    public Consumer<MyMessage> myBroadcat(){

        return new Consumer<MyMessage>() {
            @Override
            public void accept(MyMessage message) {
                log.info("接收到了广播消息：{}", message.getPayload());
            }
        };

    }


    /*
     * 消费分组消息
     */
    @Bean
    public Consumer<MyMessage> myGroup(){

        return message ->{
            log.info("接收到了分组消息：{}",message.getPayload());
        };

    }

}
