package com.aat.advancedandroidarchitecturedemo.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by 4bdul on 23/09/2019.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
