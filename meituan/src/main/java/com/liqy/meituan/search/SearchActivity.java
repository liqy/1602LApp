package com.liqy.meituan.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.liqy.meituan.BaseActivity;
import com.liqy.meituan.R;
import com.liqy.meituan.network.VolleySingleton;
import com.liqy.meituan.view.TitleBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends BaseActivity {

    //请求TAG 取消网络请求时的标记
    private static final String TAG = "Search";

    Button button; //搜素按钮
    EditText editText; //编辑框

    TagFlowLayout flowLayout;//流式布局
    KeyAdapter keyAdapter;//标签适配器

    //历史标签
    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        bar=(TitleBar)findViewById(R.id.search_title);

        button=(Button)findViewById(R.id.btn_search);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        editText=(EditText)findViewById(R.id.edit_search);
        //监听输入文字变化
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("EditText",s.toString());
                String keyword=s.toString();
                if (!TextUtils.isEmpty(keyword)){

                    keyAdapter.addItem(keyword);//增加搜索记录

                    get(s.toString());//请求数据
                }
            }
        });

        //返回按钮监听
        bar.setBarListener(new TitleBar.BarListener() {
            @Override
            public void back() {
                finish();
            }
        });

        flowLayout=(TagFlowLayout)findViewById(R.id.id_flowlayout);

        //设置数据 https://github.com/hongyangAndroid/FlowLayout

        //初始化适配器
        keyAdapter=new KeyAdapter(this, new ArrayList<String>(Arrays.asList(mVals)));
        flowLayout.setAdapter(keyAdapter);

        //设置监听方法
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                return false;
            }
        });
    }

    /**
     * 利用关键字搜索网络数据
     * @param keyword
     */
    public void get(String keyword) {

        //取消上次请求
        VolleySingleton.getInstance2().cancelReq(TAG);

        //拼接URL
        String url = "http://39.108.3.12:3000/v1/search/restaurant?keyword="+URLEncoder.encode(keyword);

        //组装请求
        //请求方法，URL，正确响应，错误响应
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(getLocalClassName(), response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.setTag(TAG);

        //添加到队列执行请求
        VolleySingleton.getInstance2().addToRequestQueue(request);
    }

}
