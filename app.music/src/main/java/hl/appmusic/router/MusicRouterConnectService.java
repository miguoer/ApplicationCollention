package hl.appmusic.router;

import android.content.Intent;
import android.util.Log;

import com.spinytech.macore.router.LocalRouterConnectService;

/**
 * Created by huanglin on 2017/4/11.
 */

public class MusicRouterConnectService extends LocalRouterConnectService {
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MRCS","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MRCS","onDestroy");
    }
}
