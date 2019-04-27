package com.example.zb.mymvp2demo;

/**
 * Created by zb on 2019/4/27.
 */

public class MvpPresenter {

    // View接口
    private MvpView mView;
    public MvpPresenter(MvpView view){
        this.mView = view;
    }
    /**
     * 获取网络数据
     * @param
     */
    public void getData(String name,String pass,String url){
        mView.showLoading();
        // 调用Model请求数据
        MvpModel.getNetData(name, pass,url,new MvpCallback(){
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                mView.showData(data);
                mView.hideLoading();
            }
            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                mView.showFailureMessage(msg);
                mView.hideLoading();
            }

        });
    }
}
