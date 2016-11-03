package com.example.com.w3d3batteryindicatorothers;

/**
 * Created by raul on 02/11/2016.
 */

public class MyBatteryFactory {
    private int level;

    public static class Factory {
        public static MyBatteryFactory create(int level) {
            MyBatteryFactory myFactory = new MyBatteryFactory();
            myFactory.level = level;
            return myFactory;
        }
    }

    public int getLevel() {
        return level;
    }
}
