package com.aat.advancedandroidarchitecturedemo.base;

import android.app.Application;

import com.aat.advancedandroidarchitecturedemo.BuildConfig;
import com.aat.advancedandroidarchitecturedemo.di.ActivityInjector;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    protected ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = initComponent();
        component.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    protected ApplicationComponent initComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
