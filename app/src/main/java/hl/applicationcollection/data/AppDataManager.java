package hl.applicationcollection.data;

import android.content.Context;

import hl.applicationcollection.data.db.AppDbHelper;
import hl.applicationcollection.data.preference.AppPreferenceHelper;
import hl.applicationcollection.main.model.NewsModel;
import hl.applicationcollection.data.db.IAppDbHelper;
import hl.applicationcollection.data.file.IAppFileHelper;
import hl.applicationcollection.data.file.AppFileHelper;
import hl.applicationcollection.data.network.IAppApiHelper;
import hl.applicationcollection.data.network.AppApiHelper;
import hl.applicationcollection.data.preference.IAppPreferenceHelper;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class AppDataManager implements IAppDataManager {
    private final static String TAG = AppDataManager.class.getCanonicalName();

    private Context context;
    private IAppDbHelper appDbHelper;
    private IAppApiHelper appApiHelper;
    private IAppFileHelper appFileHelper;
    private IAppPreferenceHelper appPreferenceHelper;

    private  static AppDataManager appDataManager;


    private AppDataManager() {
        this.appDbHelper = new AppDbHelper();
        this.appApiHelper = new AppApiHelper();
        this.appPreferenceHelper = new AppPreferenceHelper();
        this.appFileHelper = new AppFileHelper();
    }

    public static AppDataManager getInstance() {
        if (appDataManager == null) {
            appDataManager = new AppDataManager();
        }
        return appDataManager;
    }

    @Override
    public Observable<NewsModel> getNews(@Path("channels_id") int channels_id) {
        return appApiHelper.getNews(channels_id);
    }

}
