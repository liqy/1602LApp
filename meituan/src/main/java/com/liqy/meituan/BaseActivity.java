package com.liqy.meituan;

import android.support.v7.app.AppCompatActivity;

import com.liqy.meituan.view.TitleBar;

/**
 * @file FileName
 * 1602LApp
 *  * liqy
 * Copyright 星期二 YourCompany.
 */
public abstract class BaseActivity extends AppCompatActivity{
    protected TitleBar bar;

    protected abstract void initView();
}
