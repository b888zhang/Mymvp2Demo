package com.example.zb.mymvp2demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MvpView {

    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.getData)
    Button   mGetData;
    //进度条
    ProgressDialog progressDialog;
    MvpPresenter   mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        mvpPresenter = new MvpPresenter(this);
    }
    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(final String data) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mText.setText(data);
            }
        });
    }

    @Override
    public void showFailureMessage(final String msg) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.getData)
    public void onViewClicked() {
        mvpPresenter.getData("admin","123456","http://192.168.200.211:8081/GetUserInfo");
    }

}
