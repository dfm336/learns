package com.dfm.app.listener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 事件对象
 * 事件对象封装了 事件源Person
 * 在监听器上可以通过事件对象  获取到 事件源
 * @Author:代奉明
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {
    private Person person;
}
