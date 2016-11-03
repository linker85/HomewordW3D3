package com.example.com.mylibraryb;

import com.example.com.mylibraryc.CModule;

/**
 * Created by raul on 02/11/2016.
 */

public class BModule {
    public String fromBToC(String hello) {
        return new CModule().fromCEnd("->B:" + hello);
    }
}
