package com.aat.advancedandroidarchitecturedemo.data;

import com.aat.advancedandroidarchitecturedemo.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class RepoRequester {

    private final RepoService repoService;

    @Inject
    RepoRequester(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return repoService.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
