package com.dfm.app.designpatterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
public class DoorOpenCommand implements Command{

    private Door door;

    @Override
    public void execute() {
        door.open();
    }
}
