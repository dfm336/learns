package com.dfm.app.strdeal;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author:fengming.dai
 */
public class StrTest {
    public static void main(String[] args) {
        testReplace();
    }
    public static String SLASH =  "/";;


    /**
     * 路径转换
     *  将路径分隔符转为统一的 / 分隔
     * @param key 路径
     * @param isAbsolute 是否绝对路径
     *                    true：绝对路径；false：相对路径
     * @return 以 / 为分隔的路径
     */
    public static String convertPath(String key, Boolean isAbsolute) {
        key = key.replaceAll("\\\\", SLASH).replaceAll("//", SLASH);
        if (isAbsolute && !key.startsWith(SLASH)) {
            key = SLASH + key;
        } else if (!isAbsolute && key.startsWith(SLASH)) {
            key = key.replaceFirst(SLASH, "");
        }
        return key;
    }


    /**
     * 获取相对根路径的绝对路径
     * @param path 全路径   /galio/1676449749713-浙江省旅游投资集团有限公司大额基金（投资）专项风险排查情况说明及附表(盖章版）.pdf
     * @param basePath  根路径   1676449749713-浙江省旅游投资集团有限公司大额基金（投资）专项风险排查情况说明及附表(盖章版）.pdf
     * @param isAbsolute  是否绝对路径  true
     *                   true：绝对路径；false：相对路径
     * @return 完整路径
     */
    public static String replaceKey(String path, String basePath, Boolean isAbsolute) {
        String newPath;
        if ( SLASH.equals(basePath)) {
            newPath = convertPath(path, isAbsolute);
        } else {
            String temp = convertPath(path, isAbsolute);
            System.out.println("temp = " + temp);
            String regrex = convertPath(basePath, isAbsolute);
            System.out.println("regrex = " + regrex);
            newPath = temp.replaceAll(regrex, "");
        }
        return convertPath(newPath, isAbsolute);
    }


    /**
     * 把  正则表达是 匹配 的 英文括号 转为 中文括号
     * 正则表达式 Matcher 的 捕获组 发现
     * 1. 英文 左括号 会去 匹配下一个 英文右括号。
     * 没有 匹配到 会报错
     *
     * 2. 经测试 发现 就算 左右英文括号 成功匹配
     * 但是  replaceAll 希望的 替换没有发生
     * temp = /galio/1676449749713-浙江省旅游投资集团有限公司大额基金(投资)专项风险排查情况说明及附表（盖章版）
     * regrex = /1676449749713-浙江省旅游投资集团有限公司大额基金(投资)专项风险排查情况说明及附表（盖章版）
     * replaceKey = /galio/1676449749713-浙江省旅游投资集团有限公司大额基金(投资)专项风险排查情况说明及附表（盖章版）
     * @param str
     * @return
     */
    public static String replaceToChinese(String str){
        return str.replaceAll("\\(","（")
                .replaceAll("\\)","）");
    }

    public static void testReplace(){
        String error = "/galio/1676449749713-浙江省旅游投资集团有限公司大额基金（投资）专项风险排查情况说明及附表\\(盖章版）.pdf";
        String errorbase = "1676449749713-浙江省旅游投资集团有限公司大额基金（投资）专项风险排查情况说明及附表\\(盖章版）.pdf";


        String mock = "/galio/1676449749713-浙江省旅游投资集团有限公司大额基金(投资)专项风险排查情况说明及附表（盖章版）";
        String mockBase = "1676449749713-浙江省旅游投资集团有限公司大额基金(投资)专项风险排查情况说明及附表（盖章版）";
        String replaceKey = replaceKey(
                replaceToChinese(mock),
                replaceToChinese(mockBase),
                true);
        System.out.println("replaceKey = " + replaceKey);


//        String str = "有空格 有英文括号() 有中文符号（） 还有混用（).pdf";
//
//        String encodeStr = new String(mock.getBytes(), StandardCharsets.UTF_8);
//
//
//        String targetName = "1676449633017-浙江省旅游投资集团有限公司大额基金（投资）专项风险排查情况说明及附表(盖章版）.pdf";
//
//
//        String replaceAll = encodeStr.replaceAll("\\\\", SLASH).replaceAll("//", SLASH);
//        System.out.println("replaceAll = " + replaceAll);
    }
}
