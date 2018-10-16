package com.newdicooker.tempetek.mvpfin.mvp_network.activity;


import android.util.Log;

import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseObserver;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BasePresenter;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView baseView) {
        super(baseView);
    }

    public void commentAdd() {
        addDisposable(apiServer.getMain("year"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(Object o) {
                baseView.onMainSuccess((BaseModel<List<MainBean>>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }
}
