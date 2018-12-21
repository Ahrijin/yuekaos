package jinyuanyuan.bawei.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import jinyuanyuan.bawei.com.myapplication.bean.JiuData;
import jinyuanyuan.bawei.com.myapplication.view.IView;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_page;
    private String url = "http://www.zhaoapi.cn/ad/getAd";
    private ViewPage adapter;
    private List<View> pic = new ArrayList<>();
    private Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//查找控件
        adapter = new ViewPage();//设置适配器
        view_page.setAdapter(adapter);
    }

    private void initView() {
        view_page = (ViewPager) findViewById(R.id.view_page);

        LayoutInflater inflater = LayoutInflater.from(this);
        View one = inflater.inflate(R.layout.one, null);
        View two = inflater.inflate(R.layout.two, null);
        View three = inflater.inflate(R.layout.three, null);
        View four = inflater.inflate(R.layout.four, null);
        //在第四个视图查找控件
        Button start = four.findViewById(R.id.start_shopping);
        pic.add(one);
        pic.add(two);
        pic.add(three);
        pic.add(four);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    class ViewPage extends PagerAdapter{

        @Override
        public int getCount() {
            return pic.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(pic.get(position));
            return pic.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}
