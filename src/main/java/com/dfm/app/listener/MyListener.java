package com.dfm.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author:代奉明
 */
@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("bean number："+contextRefreshedEvent.getApplicationContext().getBeanDefinitionCount());
    }
}
