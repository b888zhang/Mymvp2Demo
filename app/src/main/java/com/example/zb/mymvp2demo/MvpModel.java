package com.example.zb.mymvp2demo;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * Created by zb on 2019/4/27.
 */

public class MvpModel {
    public static void getNetData(final String name,String pass,String url, final MvpCallback callback){
        HashMap<String, String> param=new HashMap<>();
        param.put("code",name);
        param.put("password",pass);
        HttpUtils.doPost(url, param, new Callback(){
            @Override
            public void onFailure(Call call, IOException e){
                callback.onFailure(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException{
                String string = response.body().string();
                callback.onSuccess(string);

            }
        });



    }

}
