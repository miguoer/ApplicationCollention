package hl.applicationcollection.main.model.data.network;


import hl.applicationcollection.main.model.NewsModel;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class MainApiHelper implements IMainApiHelper {
    @Override
    public Observable<NewsModel> getNews(@Path("channels_id") int channels_id) {
        return null;
    }
}
