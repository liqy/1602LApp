package com.liqy.meituan.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.liqy.meituan.App;

/**
 * @file FileName
 *  网络请求单例
 * Copyright 星期二 YourCompany.
 */
public class VolleySingleton {

    /**
     * 定义实例
     */
    public static volatile VolleySingleton singleton;

    //定义队列
    private static RequestQueue queue;

    //定义上下文
    private static Context context;

    /**
     * 构造函数
     *
     * @param context
     */
    public VolleySingleton(Context context) {
        this.context = context;
        queue = getQueue();
    }

    /**
     * 构造函数
     */
    public VolleySingleton() {
    }

    /**
     * 双重检测机制（懒汉模式）
     *
     * @return
     */
    public static VolleySingleton getInstance1() {
        if (singleton == null) {
            synchronized (VolleySingleton.class) {
                if (singleton == null) {
                    singleton = new VolleySingleton(App.context);
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类
     */
    private static class SingletonInstance {
        private static final VolleySingleton INSTANCE = new VolleySingleton(App.context);
    }

    /**
     * 静态内部类实现返回单例
     *
     * @return
     */
    public static VolleySingleton getInstance2() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 添加请求到队列
     *
     * @param request
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> request) {
        queue.add(request);
    }

    /**
     * 获取队列
     *
     * @return
     */
    public RequestQueue getQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        return queue;
    }

    /**
     * 取消请求
     *
     * @param tag
     */
    public void cancelReq(String tag) {
        if (queue != null)
            queue.cancelAll(tag);
    }

}
