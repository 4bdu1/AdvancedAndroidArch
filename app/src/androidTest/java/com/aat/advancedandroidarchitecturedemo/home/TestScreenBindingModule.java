package com.aat.advancedandroidarchitecturedemo.home;

import com.aat.advancedandroidarchitecturedemo.di.ControllerKey;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposComponent;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by 4bdul on 28/09/2019.
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class TestScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}

