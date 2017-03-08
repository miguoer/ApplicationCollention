package hl.applicationcollection.main.model.data;

import hl.applicationcollection.main.model.data.db.IMainDbHelper;
import hl.applicationcollection.main.model.data.file.IMainFileHelper;
import hl.applicationcollection.main.model.data.network.IMainApiHelper;
import hl.applicationcollection.main.model.data.preference.IMainPreferenceHelper;
import io.reactivex.Observable;

/**
 * Created by huanglin on 2017/3/3.
 * 邮箱：1871767675@qq.com
 */

public interface IMainDataManager extends IMainDbHelper, IMainFileHelper, IMainApiHelper, IMainPreferenceHelper {
    Observable<Boolean> loadData();
}
