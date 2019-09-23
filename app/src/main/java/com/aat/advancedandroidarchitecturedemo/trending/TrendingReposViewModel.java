package com.aat.advancedandroidarchitecturedemo.trending;

import com.aat.advancedandroidarchitecturedemo.R;
import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;
import com.aat.advancedandroidarchitecturedemo.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by 4bdul on 23/09/2019.
 */

@ScreenScope
class TrendingReposViewModel {

    private final BehaviorRelay<List<Repo>> reposRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    TrendingReposViewModel() {

    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }

    Observable<List<Repo>> repos() {
        return reposRelay;
    }


    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repos");
            errorRelay.accept(R.string.api_error_repos);
        };
    }

    Consumer<List<Repo>> reposUpdated() {
        errorRelay.accept(-1);
        return reposRelay;
    }
}
