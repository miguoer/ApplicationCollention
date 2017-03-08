package hl.applicationcollection.main.model.data;

import android.content.Context;

import hl.applicationcollection.main.model.data.db.IMainDbHelper;
import hl.applicationcollection.main.model.data.file.IMainFileHelper;
import hl.applicationcollection.main.model.data.network.IMainApiHelper;
import hl.applicationcollection.main.model.data.preference.IMainPreferenceHelper;

/**
 * Created by huanglin on 2017/3/5.
 * 邮箱：1871767675@qq.com
 */

public class MainDataManager {
    private final static String TAG = MainDataManager.class.getCanonicalName();

    private Context context;
    private  IMainDbHelper mainDbHelper;
    private  IMainApiHelper mainApiHelper;
    private  IMainFileHelper mainFileHelper;
    private  IMainPreferenceHelper mainPreferenceHelper;

    private MainDataManager() {
        //Required private constructor
    }

    public MainDataManager getInstance(IMainDbHelper mainDbHelper,
                                       IMainApiHelper mainApiHelper,
                                       IMainPreferenceHelper mainPreferenceHelper,
                                       IMainFileHelper mainFileHelper) {
        this.mainDbHelper = mainDbHelper;
        this.mainApiHelper = mainApiHelper;
        this.mainPreferenceHelper = mainPreferenceHelper;
        this.mainFileHelper = mainFileHelper;
        return MainDataManagerInstance.instance;
    }

    private static class MainDataManagerInstance {
        private static MainDataManager instance = new MainDataManager();
    }


}
