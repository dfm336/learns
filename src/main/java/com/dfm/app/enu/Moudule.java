package com.dfm.app.enu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:代奉明
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moudule {
    private Integer uuid;
    private String value;
    private Integer code;

//    public Moudule(MyEnum myEnum){
//        this.uuid = myEnum.getType();
//        this.value = myEnum.getName();
//    }
}
