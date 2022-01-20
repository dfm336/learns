package com.dfm.app.designpatterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
public class LightOffCommand implements Command{

    private Light light;

    @Override
    public void execute() {
        light.close();
    }
}
