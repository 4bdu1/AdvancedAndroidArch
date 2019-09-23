package com.aat.advancedandroidarchitecturedemo.base;

import android.app.Activity;

import com.aat.advancedandroidarchitecturedemo.home.MainActivity;
import com.aat.advancedandroidarchitecturedemo.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by 4bdul on 23/09/2019.
 */

@Module(subcomponents = {
        MainActivityComponent.class,
})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);

}
