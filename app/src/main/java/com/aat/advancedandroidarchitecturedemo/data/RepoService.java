package com.aat.advancedandroidarchitecturedemo.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by 4bdul on 23/09/2019.
 */
public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();
}
