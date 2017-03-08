package hl.applicationcollection.main.model.data;

import android.content.Context;

import hl.applicationcollection.main.model.NewsModel;
import hl.applicationcollection.main.model.data.db.IMainDbHelper;
import hl.applicationcollection.main.model.data.db.MainDbHelper;
import hl.applicationcollection.main.model.data.file.IMainFileHelper;
import hl.applicationcollection.main.model.data.file.MainFileHelper;
import hl.applicationcollection.main.model.data.network.IMainApiHelper;
import hl.applicationcollection.main.model.data.network.MainApiHelper;
import hl.applicationcollection.main.model.data.preference.IMainPreferenceHelper;
import hl.applicationcollection.main.model.data.preference.MainPreferenceHelper;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class MainDataManager implements IMainDataManager{
    private final static String TAG = MainDataManager.class.getCanonicalName();

    private Context context;
    private  IMainDbHelper mainDbHelper;
    private  IMainApiHelper mainApiHelper;
    private  IMainFileHelper mainFileHelper;
    private  IMainPreferenceHelper mainPreferenceHelper;

    private  static MainDataManager mainDataManager;


    private MainDataManager(IMainDbHelper mainDbHelper,
                           IMainApiHelper mainApiHelper,
                           IMainPreferenceHelper mainPreferenceHelper,
                           IMainFileHelper mainFileHelper) {
        this.mainDbHelper = mainDbHelper;
        this.mainApiHelper = mainApiHelper;
        this.mainPreferenceHelper = mainPreferenceHelper;
        this.mainFileHelper = mainFileHelper;
    }

    public static MainDataManager getInstance() {
        if (mainDataManager == null) {
            mainDataManager = new MainDataManager(new MainDbHelper(),
                    new MainApiHelper(),
                    new MainPreferenceHelper(),
                    new MainFileHelper());
        }
        return mainDataManager;
    }




    @Override
    public Observable<Boolean> loadData() {
        return null;
    }

    @Override
    public Observable<NewsModel> getNews(@Path("channels_id") int channels_id) {

        return null;
    }




}
