package jinyuanyuan.bawei.com.myapplication.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jinyuanyuan.bawei.com.myapplication.R;
import jinyuanyuan.bawei.com.myapplication.bean.JiuData;

public class JiuAdapter extends RecyclerView.Adapter<JiuAdapter.ViewHolder> {

    private List<JiuData.DataBean> jiuList;
    private Context context;
    private  ImageView imgs;
    private TextView title;

    public JiuAdapter(List<JiuData.DataBean> jiuList, Context context) {
        this.jiuList = jiuList;
        this.context = context;
    }

    @NonNull
    @Override
    public JiuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.jiu_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull JiuAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(jiuList.get(i).getIcon()).into(imgs);
        title.setText(jiuList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return jiuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.jiu_imgs);
            title = itemView.findViewById(R.id.jiu_title);
        }
    }
}

