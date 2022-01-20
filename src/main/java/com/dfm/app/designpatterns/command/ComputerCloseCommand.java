package com.dfm.app.designpatterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
public class ComputerCloseCommand implements Command{

    private Computer computer;

    @Override
    public void execute() {
        computer.close();
    }
}
