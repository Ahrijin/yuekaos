package jinyuanyuan.bawei.com.myapplication.model;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;

import jinyuanyuan.bawei.com.myapplication.bean.JiuData;
import jinyuanyuan.bawei.com.myapplication.callback.MyCallBack;
import jinyuanyuan.bawei.com.myapplication.utils.OkHttpUtils;

public class MyModelImpls implements MyModel {

    private MyCallBack callBack;

    @Override
    public void getData(String url, MyCallBack callBack) {
        this.callBack = callBack;
        new MyTask().execute(url);
    }

    class MyTask extends AsyncTask<String ,Void,JiuData>{

        @Override
        protected JiuData doInBackground(String... strings) {
            try {
                //请求数据
                String jsonStr = OkHttpUtils.getInstance().get(strings[0]);
                Gson gson = new Gson();
                JiuData myData = gson.fromJson(jsonStr, JiuData.class);
                return myData;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JiuData myData) {
            super.onPostExecute(myData);
            callBack.success(myData);//设置数据
        }
    }
}
