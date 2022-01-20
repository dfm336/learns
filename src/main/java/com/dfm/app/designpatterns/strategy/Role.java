package com.dfm.app.designpatterns.strategy;

import com.dfm.app.designpatterns.strategy.behaviors.AttackBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.DefendBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.DisplayBehavior;
import com.dfm.app.designpatterns.strategy.behaviors.RunBehavior;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Role {

    String name;

    AttackBehavior attackBehavior;

    DefendBehavior defendBehavior;

    RunBehavior runBehavior;

    DisplayBehavior displayBehavior;
}

