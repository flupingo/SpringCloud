package com.suning.springboot001.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created：Jeffrey
 * date   ：2022/4/25 16:27
 */
@Component
@Slf4j
public class Star {

    public void sing(String song) {
        log.info("sing放方法调用{}", song);
    }

    @Transactional
    public void laugh(String song) {
        sing(song);
        log.info("laugh方法调用");

    }


}
