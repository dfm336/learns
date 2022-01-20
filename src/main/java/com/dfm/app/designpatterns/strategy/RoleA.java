package com.dfm.app.designpatterns.strategy;

import com.dfm.app.designpatterns.strategy.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:fengming.dai
 */
@Data
@NoArgsConstructor
@ToString
public class RoleA extends Role {
    void attack(){
        this.attackBehavior.attack();
    }
    void defend(){
        this.defendBehavior.defend();
    }
    void run(){
        this.runBehavior.run();
    }
    void display(){
        this.displayBehavior.display();
    }
}
