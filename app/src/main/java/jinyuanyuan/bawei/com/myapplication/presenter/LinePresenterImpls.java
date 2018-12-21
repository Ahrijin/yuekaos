/*
package jinyuanyuan.bawei.com.myapplication.presenter;

import jinyuanyuan.bawei.com.myapplication.callback.MyCallBack;
import jinyuanyuan.bawei.com.myapplication.model.LineModelImpls;
import jinyuanyuan.bawei.com.myapplication.view.LineView;


public class LinePresenterImpls implements LinePresenter {

    private LineModelImpls lineModelImpls;
    private LineView lineView;

    public LinePresenterImpls(LineView lineView) {
        this.lineView = lineView;
        lineModelImpls = new LineModelImpls();
    }

    @Override
    public void startRequest(String url) {
        lineModelImpls.getData(url, new MyCallBack() {
            @Override
            public void success(Object d) {
                lineView.Success(d);
            }

            @Override
            public void error(Object errors) {
                lineView.Error(errors);
            }
        });
    }

    //重置数据
    public void sets() {
        if (lineModelImpls != null) {
            lineModelImpls = null;
        }
        if (lineView != null) {
            lineView = null;
        }
    }
}

*/
