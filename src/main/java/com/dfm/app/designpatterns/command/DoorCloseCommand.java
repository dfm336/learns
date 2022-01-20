package com.dfm.app.designpatterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
@AllArgsConstructor
public class DoorCloseCommand implements Command{

    private Door door;

    @Override
    public void execute() {
        door.close();
    }
}
