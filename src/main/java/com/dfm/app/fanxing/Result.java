package com.dfm.app.fanxing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:代奉明
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Result<T> {
    int code;
    String msg;
    T data;
}
