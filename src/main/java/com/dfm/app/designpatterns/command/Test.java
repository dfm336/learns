package com.dfm.app.designpatterns.command;

/**
 * 命令行模式-----行为型
 * 把请求封装为对象，将动作请求者  和动作执行 者 解耦
 * 把行为抽象为命令，通过编排命令 来完成任务
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        Command[] commands = new Command[4];
        Door door = new Door();
        Computer computer = new Computer();
        Light light = new Light();
        commands[0] = new DoorOpenCommand(door);
        commands[1] = new ComputerOpenCommand(computer);
        commands[2] = new DoorCloseCommand(door);
        commands[3] = new ComputerCloseCommand(computer);

        for(int i=0;i<4;i++){
            commands[i].execute();
        }
    }
}
