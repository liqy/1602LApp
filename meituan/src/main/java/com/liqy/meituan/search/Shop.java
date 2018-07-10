package com.liqy.meituan.search;

import com.google.gson.Gson;

/**
 * @file FileName
 * 1602LApp
 *  * liqy
 * Copyright 星期二 YourCompany.
 */
public class Shop {

    public int id;
    public String name;
    public int month_sales;
    public String month_sales_tip;
    public int wm_poi_score;
    public double delivery_score;
    public double quality_score;
    public double pack_score;
    public double food_score;
    public String delivery_time_tip;
    public String third_category;
    public String pic_url;
    public String shopping_time_start;
    public String shopping_time_end;
    public int min_price;
    public String min_price_tip;
    public int shipping_fee;
    public String shipping_fee_tip;
    public String bulletin;
    public String address;
    public String call_center;
    public String distance;
    public String average_price_tip;
    public int comment_number;
    public String lng;
    public String lat;
    public String created_at;

    public static Shop objectFromData(String str) {
        return new Gson().fromJson(str, Shop.class);
    }
}
