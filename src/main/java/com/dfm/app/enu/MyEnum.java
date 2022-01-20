package com.dfm.app.enu;

import lombok.*;

/**
 * @Author:代奉明
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum  MyEnum {
    MONDAY(1,"monday"),
    TUESDAY(2,"tuedday"),
    WEDNESDAY(3,"wednesday"),
    THURSDAY(4,"thursday"),
    FRIDAY(5,"friday"),
    SATURDAY(6,"thurday"),
    SUNDAY(7,"sunday");

    private Integer type;
    private String name;
}
