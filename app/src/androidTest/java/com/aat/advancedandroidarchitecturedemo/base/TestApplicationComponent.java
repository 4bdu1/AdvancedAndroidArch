package com.aat.advancedandroidarchitecturedemo.base;

import com.aat.advancedandroidarchitecturedemo.data.TestRepoServiceModule;
import com.aat.advancedandroidarchitecturedemo.networking.ServiceModule;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposControllerTest;
import com.aat.advancedandroidarchitecturedemo.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 4bdul on 28/09/2019.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);
}
