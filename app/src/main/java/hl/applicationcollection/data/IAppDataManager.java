package hl.applicationcollection.data;

import hl.applicationcollection.data.preference.IAppPreferenceHelper;
import hl.applicationcollection.data.db.IAppDbHelper;
import hl.applicationcollection.data.file.IAppFileHelper;
import hl.applicationcollection.data.network.IAppApiHelper;

/**
 * Created by huanglin on 2017/3/3.
 * 邮箱：1871767675@qq.com
 */

public interface IAppDataManager extends IAppDbHelper, IAppFileHelper, IAppApiHelper, IAppPreferenceHelper {
}
