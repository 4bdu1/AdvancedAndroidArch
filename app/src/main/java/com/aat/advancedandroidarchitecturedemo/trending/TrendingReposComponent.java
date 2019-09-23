package com.aat.advancedandroidarchitecturedemo.trending;

import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by 4bdul on 23/09/2019.
 */
@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {

    }
}
