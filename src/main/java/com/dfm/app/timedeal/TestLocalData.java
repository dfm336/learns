package com.dfm.app.timedeal;


import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author:fengming.dai
 */
public class TestLocalData {
    public static void main(String[] args) {
//       getYearStartDay(YearMonth.now());
//        testLong();
//        getCurMonth(6,7);
        String s = genPackTaskCode();
        System.out.println("s = " + s);
    }

    private static String genPackTaskCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        String format = sdf.format(new Date());
        long currentTimeMillis = System.currentTimeMillis();
        String timeStamp = String.valueOf(currentTimeMillis);
        String sub = timeStamp.substring(timeStamp.length() - 3);
        return "DB-" + format + sub;
    }


    public static void getYearStartDay(YearMonth yearMonth){
//        YearMonth newYearMonth = yearMonth.minusYears(1);
        DateTimeFormatter dailyFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int year = 2023;
        Date fromDate = Date.from(YearMonth.of(year, 1).atDay(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("fromDate = " + fromDate);

//        Year year = Year.now();
//        Instant instant = year.atDay(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//        Date startDay = Date.from(instant);
//        System.out.println("startDay = " + startDay);
//
//        String start = year.atDay(1).format(dailyFormatter);
//        String end = year.atMonth(12).atEndOfMonth().format(dailyFormatter);
//
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
    }

    /**
     * 获取最近的半年度/季度单位所在月
     * eg: monthQuantity = 6   , curMonth 8
     * 年度则： 1，6
     * 季度则：1，6，9，12
     * @param monthQuantity
     * @param curMonth
     * @return
     */
    private static void getCurMonth(Integer monthQuantity, Integer curMonth) {
//        int unit = 12 / monthQuantity;
//        Integer result = curMonth;
//        for (int i=0;i<unit;i++) {
//            if (i * monthQuantity < curMonth && (i+1)*monthQuantity >= curMonth) {
////                result = i == 0 ? 1 : (i * monthQuantity);
//                result = (i * monthQuantity);
//            }
//        }
//
//        System.out.println("result = " + result);
//        int year = 2023;
//        int month = result+1;
//
//        System.out.println("month = " + month);
//        Instant instant = YearMonth.of(year, month).atDay(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//        Date whatDay = Date.from(instant);
//        System.out.println("whatDay = " + whatDay);


    }

    public static void printMinMonth(){
        int year = 2023;
        int month = 1;
        YearMonth yearMonth = YearMonth.of(year, month);
//        Date to = Date.from(yearMonth.atEndOfMonth().plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println("now = " + to);
////        Date fromDate = Date.from(LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault()).minusMonths(3).minusDays(1).atZone(ZoneId.systemDefault()).toInstant());
//        Date from = Date.from(yearMonth.minusMonths(3).atDay(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println("from = " + from);


        Instant instant = YearMonth.of(year, month).atDay(1).plusDays(-1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date whatDay = Date.from(instant);
        System.out.println("whatDay = " + whatDay);

        Instant oInstant = YearMonth.of(year, month).atDay(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date originalDay = Date.from(oInstant);
        System.out.println("originalDay = " + originalDay);


    }

    public static void testLong(){
        int cnt = 12;
        Long value = Long.valueOf(cnt);
        System.out.println("value = " + value);
    }

    public static void testWeekCalculate(){
//        List<String> ids = new ArrayList<>();
//        ids.add("dfm");
//        ids.add("xxx");
//        ids.add("qlx");
//        String join = StringUtils.join(ids);
//        System.out.println("join = " + join);
//        String join = "[\"WMSJ\",\"QZSJ\"]";
//        JSONArray jsonArray = JSONArray.parseArray(join);
//        for (int i=0;i<jsonArray.size();i++){
//            System.out.println(jsonArray.getString(i));
//        }
//
//
//        JSONArray jsonArray1 = JSON.parseArray(join);
//        for (int i=0;i<jsonArray1.size();i++){
//            System.out.println(jsonArray1.getString(i));
//        }
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
