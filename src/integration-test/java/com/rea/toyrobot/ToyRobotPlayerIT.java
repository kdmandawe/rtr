package com.rea.toyrobot;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class ToyRobotPlayerIT {

    @Test
    public void testRunMain() {
        ToyRobotPlayer player = new ToyRobotPlayer();
        String path = getClass().getClassLoader().getResource("input_it_001.txt").getPath();
        player.main(new String[]{path});
    }

}