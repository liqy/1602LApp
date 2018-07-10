package com.liqy.meituan.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * @file FileName
 * 1602LApp
 *  * liqy
 * Copyright 星期二 YourCompany.
 */
public class KeyAdapter extends TagAdapter<String>{

    private Context context;
    private List<String> list;

    public KeyAdapter(Context context,List<String> datas) {
        super(datas);
        this.list=datas;
        this.context=context;
    }

    /**
     * 添加一条历史记录
     * @param item
     */
    public void addItem(String item){
        this.list.add(item);
        notifyDataChanged();
    }


    @Override
    public View getView(FlowLayout parent, int position, String s) {//类比ListView
        TextView tv = new TextView(context);
        tv.setText(s);
        return tv;
    }
}
