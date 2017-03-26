package hl.applicationcollection.main.model.data.network;

import hl.applicationcollection.main.model.NewsModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by huanglin on 2017/3/23.
 * 邮箱：1871767675@qq.com
 */

public interface ApiService {
    @GET("api/v31/channels/{channels_id}")
    Observable<NewsModel> getNews(@Path("channels_id") int channels_id);
}
