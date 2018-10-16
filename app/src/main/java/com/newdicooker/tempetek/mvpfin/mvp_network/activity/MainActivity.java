package com.newdicooker.tempetek.mvpfin.mvp_network.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.newdicooker.tempetek.mvpfin.R;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.BaseActivity;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {

    private TextView tv_msg;
    private Button btn;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        tv_msg = findViewById(R.id.tv_msg);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onMainSuccess(BaseModel<List<MainBean>> o) {
        tv_msg.setText(o.getData().toString());
    }

    @Override
    public void showError(String msg) {
        super.showError(msg);
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.commentAdd();
    }
}
