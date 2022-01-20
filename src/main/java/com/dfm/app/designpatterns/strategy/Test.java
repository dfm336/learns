package com.dfm.app.designpatterns.strategy;

import com.dfm.app.designpatterns.strategy.behaviors.AttackBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.DefendBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.DisplayBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.RunBehavior;

/**
 * 策略模式：定义了算法蔟(behaviors),分别封装起来，让他们可以互相替换。该模式让算法的变化独立于
 *          使用算法的客户。
 *
 * 1.封装变化（把可能变化的代码封装起来）
 * 2.多用组合，少用继承（使用组合的方式，给客户设置了 算法）
 * 3.针对接口编程，不针对实现（eg：对于Role类的设计，完全针对角色，和技能的实现没有关系）
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        RoleA roleA = new RoleA();
        roleA.setName("角色A");
        //以下set 的behavior 应全部采用 class 去 implement 对应 behavior 接口。

        roleA.setAttackBehavior(new AttackBehavior() {
            @Override
            public void attack() {
                System.out.println("攻击1");
            }
        });
        roleA.setDefendBehavior(new DefendBehavior() {
            @Override
            public void defend() {
                System.out.println("防御1");
            }
        });
        roleA.setRunBehavior(new RunBehavior() {
            @Override
            public void run() {
                System.out.println("跑1");
            }
        });
        roleA.setDisplayBehavior(new DisplayBehavior() {
            @Override
            public void display() {
                System.out.println("样貌1");
            }
        });
        roleA.attack();
        roleA.defend();
        roleA.run();
        roleA.display();
    }
}
