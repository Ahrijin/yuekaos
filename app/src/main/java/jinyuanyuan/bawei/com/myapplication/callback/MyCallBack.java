package jinyuanyuan.bawei.com.myapplication.callback;

public interface MyCallBack<T> {
    void success(T d);
    void error(T errors);
}
