package com.aat.advancedandroidarchitecturedemo.base;

import android.app.Activity;

import com.aat.advancedandroidarchitecturedemo.home.MainActivity;
import com.aat.advancedandroidarchitecturedemo.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by 4bdul on 28/09/2019.
 */
@Module(subcomponents = TestMainActivityComponent.class)
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}
