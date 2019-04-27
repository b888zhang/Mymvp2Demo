package com.example.zb.mymvp2demo;

/**
 * Created by zb on 2019/4/27.
 */

public interface MvpCallback {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(String data);
    /**
     *  使用网络API接口请求方式时，虽然已经请求成功但是由
     *  于{@code msg}的原因无法正常返回数据。
     */
    void onFailure(String msg);


}
