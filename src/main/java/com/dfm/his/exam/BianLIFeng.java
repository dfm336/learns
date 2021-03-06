package com.dfm.his.exam;

/**
 * @author dfm
 * @create 2020-10-19 20:41
 */
public class BianLIFeng {
    /**
     * 2.给定一份乱序日志文件, 日志文件使用 "|" 分隔, 分隔后的每一条日志是当天门店的顾客进出记录, 代表一次顾客进出便利店的记录, 格式为 [uid, in, ts] 或 [uid, out, ts], 其中 uid 是用户 id, in/out 表示进出门店,  ts 是时间, 代表当天的秒数, 如 ts=0, 则代表当天 00:00, ts=3600, 则代表当天 1:00, 求当天门店内的最大店内人数
     *
     *
     *
     * 输入描述
     * public static int maxNumOfCustomer(String customerLogs)
     *
     * 说明：
     *
     * cutomLogs: 顾客进出店日志字符串
     *
     * 输出描述
     * 返回：最大在店人数
     *
     *
     * 样例输入
     * 72229,in,20931|72229,in,20931|72229,in,20931|21257,out,68387|21257,out,68387|21257,in,68387|66362,in,31725|66362,in,31725|66362,in,3172
     * 样例输出
     * 6
     */

    /**
     * 1.对于下图所示二叉树，2和8的最短路径是2，8和6的最短路径是5。
     *
     * 假定二叉树各个节点值唯一，求由这两个数组构造出的二叉树上，两个节点的最短路径。
     *
     *
     *
     *
     *
     * 输入描述
     * public static int getLength(int[][] tree, int start, int end)
     *
     * 说明：
     *
     * tree 二维数组描述的树结构，结构为：[[父节点, 子节点], [父节点, 子节点], ... [父节点, 子节点]]
     *
     * start 起点节点值
     *
     * end 终点节点值
     *
     * 输出描述
     * 返回：最短路径
     *
     *
     * 样例输入
     * [[1,2],[1,3],[2,4],[2,5],[4,8],[4,9],[3,6],[3,7]],2,8
     * 样例输出
     * 2
     *
     * 提示
     * 样例 2：
     * 输入：
     * [[1,2],[1,3],[2,4],[2,5],[4,8],[4,9],[3,6],[3,7]],8,6
     * 输出：
     * 5
     */
    /**
     * 3.在相同设备(device)登陆过的用户(user)称为有关联(如果user1和2有关联, 2和3有关联, 那么1和3也有关联). 请实现一个查询关联用户的功能, 返回userId的关联用户的数量.
     *
     *
     *
     * 输入描述
     * public int cluster(List<String[]> loginInfo, String userId)
     *
     * 说明：
     *
     * loginInfo: 所有用户的登录记录
     *
     * userId: 需要查找的用户
     *
     * 输出描述
     * 返回：需要查找的用户对应的关联用户数量
     *
     *
     * 样例输入
     * user1,device1
     * user2,device2
     * user3,device1
     * user1
     * 样例输出
     * 2
     */
}
