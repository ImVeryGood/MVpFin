package com.newdicooker.tempetek.mvpfin.mvp_network.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.newdicooker.tempetek.mvpfin.R;
import com.newdicooker.tempetek.mvpfin.mvp_network.activity.MainBean;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.BaseActivity;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MoviesActivity extends BaseActivity<MoviePresenter> implements MovieView {

    @BindView(R.id.list_view)
    TextView textView;

    @Override
    protected MoviePresenter createPresenter() {
        return new MoviePresenter(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_movies;
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        mPresenter.getData();

    }

    @Override
    public void onMovieSuccess(BaseModel<List<MainBean>> o) {
        textView.setText(o.getData().toString());
    }



    @OnClick({R.id.btn, R.id.btn_no})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                mPresenter.getData();
                break;
            case R.id.btn_no:
                break;
        }
    }
}
