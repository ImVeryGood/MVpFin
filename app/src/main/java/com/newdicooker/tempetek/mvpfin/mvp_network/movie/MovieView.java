package com.newdicooker.tempetek.mvpfin.mvp_network.movie;

import com.newdicooker.tempetek.mvpfin.mvp_network.activity.MainBean;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseView;

import java.util.List;

/**
 * Created by SPC
 * on 2018/10/16
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public interface MovieView extends BaseView {
    void onMovieSuccess(BaseModel<List<MainBean>> o);
}
