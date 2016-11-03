package com.example.com.mybatterymodule;

import com.example.com.mylibraryb.BModule;

/**
 * Created by raul on 02/11/2016.
 */

public class BatteryModule {

    private BatteryModule() {

    }

    private static class MySingletonHolder {
        public static final BatteryModule instance = new BatteryModule();
    }

    public static BatteryModule getMySingleton() {
        return MySingletonHolder.instance;
    }

    public String fromAToB(String hello) {
        return new BModule().fromBToC("a:" + hello);
    }
}
