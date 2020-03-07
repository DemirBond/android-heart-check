package com.szg_tech.heartcheck.core;

import android.app.Application;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;

import io.realm.Realm;


public class CVDApplication extends Application implements LifecycleObserver {

//    static final long RESTART_TIMEOUT = 5*60*1000;

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        Realm.init(this);
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    void onAppBackgrounded() {
//       PreferenceHelper.saveLastTimeUsed(this);
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    void onAppForegrounded() {
//        long lastTimeUsed = PreferenceHelper.getLastTimeUsed(this);
//        if(System.currentTimeMillis() > lastTimeUsed + RESTART_TIMEOUT){
//            Intent i = getBaseContext().getPackageManager()
//                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
//            if (i != null) {
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            }
//            startActivity(i);
//        }
//    }
}
