package com.dfm.app.jsondeal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @Author:fengming.dai
 */
public class JsonUtils {
    public static final ObjectMapper mapper = new ObjectMapper();
    static {
        /**
         * 序列化时 包括的 属性
         *  always - 所有
         *  NON_NULL  --- 不为空 的属性 ？
         *
         *  也可以使用注解在PO类上：
         * @JsonIgnore 一定 该属性 不转化为 json
         * @JsonInclude(value = Include.NON_NULL)为 null 不转化
         */
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //反序列化 时 如果多了其他 属性 不抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //如果是 空对象 不抛出异常
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

        /**
         * 取消 时间的转化格式，默认是 时间戳，可以取消，同时 需要设置表现的时间格式
         */
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }



    public static String objectToJsonStr(Object object){
        return null;
    }

    public static Object jsonStr2Object(String jsonStr){
        return null;
    }
}
