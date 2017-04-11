package hl.applicationcollection.router;

import com.spinytech.macore.MaProvider;

/**
 * Created by huanglin on 2017/4/11.
 */

public class MainProvider extends MaProvider{
    @Override
    protected void registerActions() {
        registerAction("attachment",new AttachObjectAction());

    }
}
