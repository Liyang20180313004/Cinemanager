package xyz.changzhen.cinemanager.utils;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * @author zhen
 */
public class AppUtils extends Application {
//    private static Context mContext;
    private static WeakReference<Application> mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = new WeakReference<Application>(this);
    }

    public static Context getContext() {
        return mContext.get();
    }
}
