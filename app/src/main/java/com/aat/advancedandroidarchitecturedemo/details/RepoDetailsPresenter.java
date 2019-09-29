package com.aat.advancedandroidarchitecturedemo.details;

import com.aat.advancedandroidarchitecturedemo.data.RepoRepository;
import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by 4bdul on 29/09/2019.
 */

@ScreenScope
public class RepoDetailsPresenter {

    @Inject
    RepoDetailsPresenter(
            @Named("repo_owner") String repoOwner,
            @Named("repo_name") String repoName,
            RepoRepository repoRepository,
            RepoDetailsViewModel repoDetailsViewModel
    ) {
        repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(repoDetailsViewModel.processRepo())
                .doOnError(repoDetailsViewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl()))
                .doOnError(repoDetailsViewModel.contributorsError())

                .subscribe(repoDetailsViewModel.processContributors(), throwable -> {
                    //Handling in view model
                });
    }
}
