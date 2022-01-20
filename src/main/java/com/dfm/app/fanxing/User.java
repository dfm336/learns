package com.dfm.app.fanxing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:代奉明
 */
@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class User {
    int age;
    String name;
    Handler handler;
}
