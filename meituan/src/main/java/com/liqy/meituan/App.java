package com.liqy.meituan;

import android.app.Application;
import android.content.Context;

/**
 * @file FileName
 * 1602LApp
 *  * liqy
 * Copyright 星期二 YourCompany.
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }


}
