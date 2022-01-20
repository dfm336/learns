package com.dfm.app.timedeal;


import cn.tongdun.fast2jack.JSON;
import cn.tongdun.fast2jack.JSONArray;
import com.dfm.app.fanxing.User;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author:fengming.dai
 */
public class TestLocalData {
    public static void main(String[] args) {
        testWeekCalculate();
    }

    public static void testWeekCalculate(){
//        List<String> ids = new ArrayList<>();
//        ids.add("dfm");
//        ids.add("xxx");
//        ids.add("qlx");
//        String join = StringUtils.join(ids);
//        System.out.println("join = " + join);
        String join = "[\"WMSJ\",\"QZSJ\"]";
        JSONArray jsonArray = JSONArray.parseArray(join);
        for (int i=0;i<jsonArray.size();i++){
            System.out.println(jsonArray.getString(i));
        }


        JSONArray jsonArray1 = JSON.parseArray(join);
        for (int i=0;i<jsonArray1.size();i++){
            System.out.println(jsonArray1.getString(i));
        }
//        String s = "dfm,fxx";
//        String[] split = s.split(",");
//        Arrays.asList(split).forEach(x-> System.out.println(x));
//
//        //11.3
//        Long startTS = 1635921870000L;
//        //11.25
//        Long endTS = 1637822670000L;
//
//        LocalDate startLocalDate =  LocalDateTime.ofInstant(new Date(startTS).toInstant(), ZoneId.systemDefault()).toLocalDate();
//        int startOffset = startLocalDate.getDayOfWeek().getValue();
//        //统计开始 所在周的 周一
//        startLocalDate = startLocalDate.minusDays(startOffset - 1);
//        LocalDate endLocalDate = LocalDateTime.ofInstant(new Date(endTS).toInstant(), ZoneId.systemDefault()).toLocalDate();
//        int endOffset = endLocalDate.getDayOfWeek().getValue();
//        //统计结束时间 所在的 周日
//        endLocalDate = endLocalDate.plusDays(7 - endOffset);
//        System.out.println("startLocalDate = " + startLocalDate);
//        System.out.println("endLocalDate = " + startLocalDate.plusDays(6));

//        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
//        LocalDateTime addHour = localDateTime.plusHours(25);
//        System.out.println("localDateTime = " + addHour);
//
//        LocalDateTime addDa = localDateTime.plusDays(1);
//        System.out.println("addDa = " + addDa);
    }
}
