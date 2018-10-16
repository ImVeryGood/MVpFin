package com.newdicooker.tempetek.mvpfin.mvp_network.movie;

import com.newdicooker.tempetek.mvpfin.mvp_network.activity.MainBean;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseObserver;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BasePresenter;

import java.util.List;

/**
 * Created by SPC
 * on 2018/10/16
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class MoviePresenter extends BasePresenter<MovieView> {
    public MoviePresenter(MovieView baseView) {
        super(baseView);
    }
    public void getData(){
        addDisposable(apiServer.getMain("year"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(Object o) {
                baseView.onMovieSuccess((BaseModel<List<MainBean>>) o);
            }

            @Override
            public void onError(String msg) {
            baseView.showError(msg);
            }
        });
    }
}
