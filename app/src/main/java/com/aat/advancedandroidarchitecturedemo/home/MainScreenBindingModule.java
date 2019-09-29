package com.aat.advancedandroidarchitecturedemo.home;

import com.aat.advancedandroidarchitecturedemo.details.RepoDetailsComponent;
import com.aat.advancedandroidarchitecturedemo.details.RepoDetailsController;
import com.aat.advancedandroidarchitecturedemo.di.ControllerKey;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposComponent;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by 4bdul on 23/09/2019.
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
        RepoDetailsComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);
}
