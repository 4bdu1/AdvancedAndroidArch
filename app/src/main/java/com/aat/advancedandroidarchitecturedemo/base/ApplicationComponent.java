package com.aat.advancedandroidarchitecturedemo.base;

import com.aat.advancedandroidarchitecturedemo.data.RepoServiceModule;
import com.aat.advancedandroidarchitecturedemo.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 4bdul on 23/09/2019.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
