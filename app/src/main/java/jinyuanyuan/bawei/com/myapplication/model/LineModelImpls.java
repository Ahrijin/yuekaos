/*
package jinyuanyuan.bawei.com.myapplication.model;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;

import jinyuanyuan.bawei.com.myapplication.bean.MyData;
import jinyuanyuan.bawei.com.myapplication.callback.MyCallBack;
import jinyuanyuan.bawei.com.myapplication.utils.OkHttpUtils;

public class LineModelImpls implements LineModel {
    private MyCallBack callBack;
    @Override
    public void getData(String url, MyCallBack callBack) {
        this.callBack = callBack;
        new MyTask().execute(url);
    }

    class MyTask extends AsyncTask<String ,Void,MyData> {

        @Override
        protected MyData doInBackground(String... strings) {
            try {
                //请求数据
                String jsonStr = OkHttpUtils.getInstance().get(strings[0]);
                Gson gson = new Gson();
                MyData myData = gson.fromJson(jsonStr, MyData.class);
                return myData;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(MyData myData) {
            super.onPostExecute(myData);
            callBack.success(myData);//设置数据
        }
    }
}
*/
