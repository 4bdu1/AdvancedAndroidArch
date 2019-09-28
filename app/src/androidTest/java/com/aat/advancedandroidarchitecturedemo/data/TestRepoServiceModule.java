package com.aat.advancedandroidarchitecturedemo.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by 4bdul on 28/09/2019.
 */
@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindRepoService(TestRepoService repoService);
}