package jinyuanyuan.bawei.com.myapplication.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private OkHttpClient okHttpClient;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient();
    }

    public static OkHttpUtils getInstance(){
        return OkHttpHolder.utils;
    }

    private static class OkHttpHolder{
        private static final OkHttpUtils utils = new OkHttpUtils();
    }

    //get
    public String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response execute = okHttpClient.newCall(request).execute();
        return execute.body().string();
    }
}
