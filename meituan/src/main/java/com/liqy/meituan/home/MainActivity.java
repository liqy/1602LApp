package com.liqy.meituan.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.liqy.meituan.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    private static final String TAG="Search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.vp);

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);//关联
        tabLayout.setupWithViewPager(viewPager);//关联

        get();

    }

    public void get(){
        //创建请求队列(重复)
        RequestQueue queue = Volley.newRequestQueue(this);

        //拼接URL
        String url="http://39.108.3.12:3000/v1/search/restaurant?keyword=%E9%BA%A6%E5%BD%93";

        //组装请求
        //请求方法，URL，正确响应，错误响应
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(getLocalClassName(),response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        request.setTag(TAG);
        queue.add(request);
    }

    class  MyViewPagerAdapter extends FragmentPagerAdapter{

        private final String[] title = new String[]{
                "推荐", "热点", "视频", };

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0){
                //TODO
            }

            if (position==1){
                //TODO
            }

            return HomeFragment.newInstance(title[position],"");
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
