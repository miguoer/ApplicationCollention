package hl.appmusic;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by huanglin on 2017/4/11.
 */
public class Music {
    MediaPlayer mp;

    public Music(Context context) {
        mp = MediaPlayer.create(context, R.raw.music);
    }

    public void play() {
        try {
            if (mp != null) {
                mp.stop();
            }
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (mp != null) {
                mp.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}