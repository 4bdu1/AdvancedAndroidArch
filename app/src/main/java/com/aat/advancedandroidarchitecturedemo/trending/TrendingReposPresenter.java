package com.aat.advancedandroidarchitecturedemo.trending;

import com.aat.advancedandroidarchitecturedemo.data.RepoRequester;
import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;
import com.aat.advancedandroidarchitecturedemo.model.Repo;

import javax.inject.Inject;

/**
 * Created by 4bdul on 23/09/2019.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester) {

        this.viewModel = viewModel;
        this.repoRequester = repoRequester;

        loadRepos();
    }

    private void loadRepos() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((data, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
