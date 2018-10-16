package com.newdicooker.tempetek.mvpfin.mvp_network.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.tu.loadingdialog.LoadingDailog;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseModel;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BasePresenter;
import com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseView;
import com.newdicooker.tempetek.mvpfin.mvp_network.promptdialog.PromptDialog;
import com.newdicooker.tempetek.mvpfin.mvp_network.utils.StatusBarUtil;

import butterknife.ButterKnife;

import static com.newdicooker.tempetek.mvpfin.mvp_network.base.mvp.BaseObserver.NETWORK_ERROR;


/**
 * File descripition: activity基类
 * <p>
 *
 * @author lp
 * @date 2018/5/16
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected final String TAG = this.getClass().getSimpleName();
    public Context mContext;
    protected P mPresenter;
    protected abstract P createPresenter();
    //错误提示框  警告框  成功提示框 加载进度框 （只是提供个案例 可自定义）
    private PromptDialog promptDialog;
    protected LoadingDailog loadingDailog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        mPresenter = createPresenter();
        setStatusBar();
        this.initToolbar(savedInstanceState);
        this.initData();

    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();
    /**
     * 处理顶部title
     *
     * @param savedInstanceState
     */
    protected abstract void initToolbar(Bundle savedInstanceState);
    /**
     * 数据初始化操作
     */
    protected abstract void initData();
    /**
     * 此处设置沉浸式地方
     */
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
    }
    /**
     * 封装toast方法（自行去实现）
     *
     * @param str
     */
    public void showToast(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String str) {
    }
    @Override
    public void showError(String msg) {
        showToast(msg);
    }
    /**
     * 返回所有状态  除去指定的值  可设置所有（根据需求）
     *
     * @param model
     */
    @Override
    public void onErrorCode(BaseModel model) {
        if (model.getErrcode() == NETWORK_ERROR) {

        }
    }
    //显示加载进度框回调
    @Override
    public void showLoading() {
        setLoading();
        loadingDailog.show();
    }
    //隐藏进度框回调
    @Override
    public void hideLoading() {
        loadingDailog.dismiss();
    }

    protected void setLoading() {
      LoadingDailog.Builder builder = new LoadingDailog.Builder(this)
                .setMessage("加载中")
                .setCancelable(true);
        loadingDailog = builder.create();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
