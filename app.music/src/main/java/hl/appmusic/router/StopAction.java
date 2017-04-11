package hl.appmusic.router;

import android.content.Context;
import android.content.Intent;

import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;
import com.spinytech.macore.tools.Logger;

import java.util.HashMap;

import hl.appmusic.MusicService;

/**
 * Created by huanglin on 2017/4/11.
 */

public class StopAction extends MaAction {

    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Intent intent = new Intent(context, MusicService.class);
        intent.putExtra("command", "stop");
        context.startService(intent);
        MaActionResult result = new MaActionResult.Builder()
                .code(MaActionResult.CODE_SUCCESS)
                .msg("stop success")
                .data("")
                .object(null)
                .build();

        Logger.d("StopAction", "\nStopAction end: " + System.currentTimeMillis());
        return result;
    }
}
