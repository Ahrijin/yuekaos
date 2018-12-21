package jinyuanyuan.bawei.com.myapplication.presenter;

import jinyuanyuan.bawei.com.myapplication.callback.MyCallBack;
import jinyuanyuan.bawei.com.myapplication.model.MyModelImpls;
import jinyuanyuan.bawei.com.myapplication.view.IView;

public class PresenterImpls implements IPresenter {

    private MyModelImpls myModelImpls;
    private IView iView;

    public PresenterImpls(IView iView) {
        this.iView = iView;
        myModelImpls = new MyModelImpls();
    }

    @Override
    public void startRequest(String url) {
        myModelImpls.getData(url, new MyCallBack() {
            @Override
            public void success(Object d) {
                iView.getSuccess(d);
            }

            @Override
            public void error(Object errors) {
                iView.getError(errors);
            }
        });
    }
    //重置数据
    public void sets(){
        if (myModelImpls!=null){
            myModelImpls = null;
        }
        if(iView != null){
            iView = null;
        }
    }
}
