package com.aat.advancedandroidarchitecturedemo.data;

import com.aat.advancedandroidarchitecturedemo.model.Contributor;
import com.aat.advancedandroidarchitecturedemo.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by 4bdul on 23/09/2019.
 */
public class RepoRequester {

    private final RepoService repoService;

    @Inject
    RepoRequester(RepoService repoService) {
        this.repoService = repoService;
    }

    Single<List<Repo>> getTrendingRepos() {
        return repoService.getTrendingRepos()
                .map(TrendingReposResponse::repos);
//                .subscribeOn(Schedulers.io());
    }

    Single<Repo> getRepo(String repoOwner, String repoName) {
        return repoService.getRepo(repoOwner, repoName);
//        .subscribeOn(Schedulers.io());
    }

    Single<List<Contributor>> getContributors(String url) {
        return repoService.getContributors(url);
    }
}
