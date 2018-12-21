package jinyuanyuan.bawei.com.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import jinyuanyuan.bawei.com.myapplication.R;
import jinyuanyuan.bawei.com.myapplication.bean.MyData;


public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder> {
    private List<MyData.DataBean> mLists;
    private Context context;
    private ImageView lineImage;
    private TextView lineTitle;
    private TextView lineprice;

    public LineAdapter(List<MyData.DataBean> mLists, Context context) {
        this.mLists = mLists;
        this.context = context;
    }

    @NonNull
    @Override
    public LineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.line_item, null);//加载布局
        LineAdapter.ViewHolder holder = new LineAdapter.ViewHolder(view);
        return holder;//返回holder
    }

    @Override
    public void onBindViewHolder(@NonNull LineAdapter.ViewHolder viewHolder, int i) {
        lineTitle.setText(mLists.get(i).getList().get(i).getTitle());
        lineprice.setText(mLists.get(i).getList().get(i).getPrice());//设置数据
        Glide.with(context).load(mLists.get(i).getList().get(i).getImages()).into(lineImage);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //查找控件
            lineImage = itemView.findViewById(R.id.line_imgs);
            lineTitle = itemView.findViewById(R.id.line_title);
            lineprice = itemView.findViewById(R.id.line_price);
        }
    }
}
