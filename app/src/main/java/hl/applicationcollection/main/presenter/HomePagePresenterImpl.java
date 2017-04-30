package hl.applicationcollection.main.presenter;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.spinytech.macore.MaApplication;
import com.spinytech.macore.router.LocalRouter;
import com.spinytech.macore.router.RouterRequest;
import com.spinytech.macore.router.RouterResponse;

import hl.applicationcollection.base.BasePresenterImpl;
import hl.applicationcollection.base.IBaseView;
import hl.applicationcollection.main.model.NewsModel;
import hl.applicationcollection.data.AppDataManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by huanglin on 2017/2/23.
 * 邮箱：1871767675@qq.com
 */

public class HomePagePresenterImpl extends BasePresenterImpl<IBaseView> {

    public HomePagePresenterImpl(IBaseView iBaseView) {
        attachView(iBaseView);
    }

    /**
     * 加载数据，测试
     */
    public void loadData() {
        view.showWaitingDialog();

        getCompositeDisposable().add(AppDataManager.getInstance().getNews(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsModel>() {
                    @Override
                    public void accept(NewsModel newsModel) throws Exception {
                        Logger.e("accept", "llll");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                })
        );
    }

    /**
     * 播放音乐
     */
    public void playMusic() {

    }
}
