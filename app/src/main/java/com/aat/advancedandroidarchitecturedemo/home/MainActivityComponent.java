package com.aat.advancedandroidarchitecturedemo.home;

import com.aat.advancedandroidarchitecturedemo.di.ActivityScope;
import com.aat.advancedandroidarchitecturedemo.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by 4bdul on 23/09/2019.
 */
@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
