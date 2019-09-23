package com.aat.advancedandroidarchitecturedemo.base;

import android.app.Application;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class MyApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
