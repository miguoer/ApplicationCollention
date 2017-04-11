package hl.appmusic.router;

import com.spinytech.macore.MaProvider;

/**
 * Created by huanglin on 2017/4/11.
 */

public class MusicProvider extends MaProvider {
    @Override
    protected void registerActions() {
        registerAction("play",new PlayAction());
        registerAction("stop",new StopAction());
        registerAction("shutdown",new ShutdownAction());
    }
}
