package com.suning.springboot001.listener;

import com.rabbitmq.client.Channel;
import com.suning.springboot001.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created：Jeffrey
 * date   ：2022/5/5 21:50
 */
@org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "atguigu")
@Service
@Slf4j
public class RabbitListener {

    @RabbitHandler
    public void consumerMessage(Channel channel, Message message, Account account) throws IOException, InterruptedException {
        Thread.sleep(5000);
        log.info("===消费者开始消费===");
        System.out.println(account);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        log.info("===消费者完成消费====");
    }


}
