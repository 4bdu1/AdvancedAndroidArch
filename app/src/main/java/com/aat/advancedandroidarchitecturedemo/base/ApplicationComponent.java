package com.aat.advancedandroidarchitecturedemo.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 4bdul on 23/09/2019.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
})
public interface ApplicationComponent {
}
