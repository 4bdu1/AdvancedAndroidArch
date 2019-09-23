package com.aat.advancedandroidarchitecturedemo.base;

import android.app.Application;

import com.aat.advancedandroidarchitecturedemo.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
