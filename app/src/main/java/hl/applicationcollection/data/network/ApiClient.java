package hl.applicationcollection.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import hl.applicationcollection.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**封装网络请求客户端
 * Created by huanglin on 2017/3/3.
 * 邮箱：1871767675@qq.com
 */

public class ApiClient {

    public static Retrofit getRetrofit(String baseUrl) {


        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


}
