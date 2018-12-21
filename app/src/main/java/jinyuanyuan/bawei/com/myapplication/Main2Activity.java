package jinyuanyuan.bawei.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import jinyuanyuan.bawei.com.myapplication.adapter.JiuAdapter;
import jinyuanyuan.bawei.com.myapplication.adapter.LineAdapter;
import jinyuanyuan.bawei.com.myapplication.bean.JiuData;
import jinyuanyuan.bawei.com.myapplication.bean.MyData;
import jinyuanyuan.bawei.com.myapplication.presenter.PresenterImpls;
import jinyuanyuan.bawei.com.myapplication.view.IView;
import jinyuanyuan.bawei.com.myapplication.view.LineView;

public class Main2Activity extends AppCompatActivity implements IView {

    private ImageView imgs_er;
    private EditText edit_search;
    private ImageView imgs_qie;
    private RecyclerView recy_view1;
    private RecyclerView recy_view2;
    private List<JiuData.DataBean> jiu = new ArrayList<>();
    private List<MyData.DataBean> linegrid = new ArrayList<>();
    private JiuAdapter jiuAdapter;
    private LineAdapter lineAdapter;
    private PresenterImpls presenterImpls;
    private String mUrl = "http://www.zhaoapi.cn/product/getCatagory";
    private String mUrl2 = "http://www.zhaoapi.cn/product/getCarts?uid=71";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();//查找控件
        //初始化p层
        presenterImpls = new PresenterImpls(this);
        presenterImpls.startRequest(mUrl);
        //设置适配器
        jiuAdapter = new JiuAdapter(jiu,Main2Activity.this);
        recy_view1.setAdapter(jiuAdapter);

        /*linePresenterImpls = new LinePresenterImpls(this);
        linePresenterImpls.startRequest(mUrl2);
        lineAdapter = new LineAdapter(linegrid,Main2Activity.this);
        recy_view2.setAdapter(lineAdapter);*/
    }

    private void initView() {
        imgs_er = (ImageView) findViewById(R.id.imgs_er);
        edit_search = (EditText) findViewById(R.id.edit_search);
        imgs_qie = (ImageView) findViewById(R.id.imgs_qie);


        recy_view1 = (RecyclerView) findViewById(R.id.recy_view1);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(Main2Activity.this,5);
        recy_view1.setLayoutManager(gridLayoutManager1);

        recy_view2 = (RecyclerView) findViewById(R.id.recy_view2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this);
        recy_view2.setLayoutManager(linearLayoutManager);


    }



    @Override
    public void getSuccess(Object dd) {
        //获取数据，刷新适配器
        JiuData jiuData = (JiuData) dd;
        jiu.addAll(jiuData.getData());
        jiuAdapter.notifyDataSetChanged();
    }

    @Override
    public void getError(Object error) {

    }


}
