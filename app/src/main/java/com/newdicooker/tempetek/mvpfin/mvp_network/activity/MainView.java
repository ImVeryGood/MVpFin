package com.newdicooker.tempetek.mvpfin.mvp_network.activity;


import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseView;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface MainView extends BaseView {
    void onMainSuccess(BaseModel<List<MainBean>> o);
}
