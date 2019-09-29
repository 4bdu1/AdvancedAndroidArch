package com.aat.advancedandroidarchitecturedemo.trending;

import com.aat.advancedandroidarchitecturedemo.data.RepoRepository;
import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;
import com.aat.advancedandroidarchitecturedemo.model.Repo;

import javax.inject.Inject;

/**
 * Created by 4bdul on 23/09/2019.
 */
@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository) {

        this.viewModel = viewModel;
        this.repoRepository = repoRepository;

        loadRepos();
    }

    private void loadRepos() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((data, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {

    }
}
