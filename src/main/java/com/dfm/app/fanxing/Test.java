package com.dfm.app.fanxing;

/**
 * @Author:代奉明
 */
public class Test {
    public static void main(String[] args) {
        User dfm = new User(21, "dfm", new Handler() {
            @Override
            public User deal(String content) {
                return null;
            }
        });
        System.out.println("dfm = " + dfm);


//        User dfm = new User(21, "dfm");
//        Result<User> userResult = new Result<>(200, "success", new User(22, "xxx"));
//        System.out.println(userResult);
//        System.out.println(userResult.getData());
    }


}
