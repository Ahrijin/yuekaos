package jinyuanyuan.bawei.com.myapplication.view;

public interface IView<T> {
    void getSuccess(T dd);
    void getError(T error);
}
