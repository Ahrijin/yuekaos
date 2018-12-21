package jinyuanyuan.bawei.com.myapplication.view;

public interface LineView<T> {
    void Success(T dd);
    void Error(T error);
}
