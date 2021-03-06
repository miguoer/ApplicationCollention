package hl.applicationcollection.data.network;


import hl.applicationcollection.main.model.NewsModel;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class AppApiHelper implements IAppApiHelper {
    public static final String BAOZOU = "http://dailyapi.ibaozou.com";


    @Override
    public Observable<NewsModel> getNews(@Path("channels_id") int channels_id) {
        return  ApiClient.getRetrofit(BAOZOU).create(ApiService.class).getNews(channels_id);
    }
}
