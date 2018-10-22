package com.newdicooker.tempetek.mvpfin.mvp_network.movie;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.newdicooker.tempetek.mvpfin.R;
import com.newdicooker.tempetek.mvpfin.mvp_network.activity.MainBean;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.BaseActivity;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;

import java.util.List;

import butterknife.BindView;

/**
 * tablayout+viewpager+fragment
 */
public class MoviesActivity extends BaseActivity<MoviePresenter> implements MovieView {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    protected FragmentAdapter adapter;
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
        tabLayout.setupWithViewPager(viewPager);
        adapter=new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


    }

    @Override
    public void onMovieSuccess(BaseModel<List<MainBean>> o) {

    }

}
