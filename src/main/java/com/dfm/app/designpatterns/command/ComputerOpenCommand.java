package com.dfm.app.designpatterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
public class ComputerOpenCommand implements Command{

    private Computer computer;

    @Override
    public void execute() {
        computer.open();
    }
}
