package com.aat.advancedandroidarchitecturedemo.details;

import com.aat.advancedandroidarchitecturedemo.R;
import com.aat.advancedandroidarchitecturedemo.di.ScreenScope;
import com.aat.advancedandroidarchitecturedemo.model.Contributor;
import com.aat.advancedandroidarchitecturedemo.model.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by 4bdul on 29/09/2019.
 */

@ScreenScope
public class RepoDetailsViewModel {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private final BehaviorRelay<RepoDetailsState> detailsStateBehaviorRelay = BehaviorRelay.create();
    private final BehaviorRelay<ContributorState> contributorStateBehaviorRelay = BehaviorRelay.create();

    @Inject
    RepoDetailsViewModel() {
        detailsStateBehaviorRelay.accept(RepoDetailsState.builder().loading(true).build());
        contributorStateBehaviorRelay.accept(ContributorState.builder().loading(true).build());
    }

    Observable<RepoDetailsState> details() {
        return detailsStateBehaviorRelay;
    }

    Observable<ContributorState> contributors() {
        return contributorStateBehaviorRelay;
    }

    Consumer<Repo> processRepo() {
        return repo ->
                detailsStateBehaviorRelay.accept(
                        RepoDetailsState.builder()
                                .loading(false)
                                .name(repo.name())
                                .description(repo.description())
                                .createdDate(repo.createdDate().format(DATE_TIME_FORMATTER))
                                .updatedDate(repo.updatedDate().format(DATE_TIME_FORMATTER))
                                .build()
                );
    }

    Consumer<List<Contributor>> processContributors() {
        return contributors ->
                contributorStateBehaviorRelay.accept(
                        ContributorState.builder()
                                .loading(false)
                                .contributors(contributors)
                                .build()
                );
    }

    Consumer<Throwable> detailsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repo details");
            detailsStateBehaviorRelay.accept(RepoDetailsState.builder()
                    .loading(false)
                    .errorRes(R.string.api_error_single_repo)
                    .build()
            );
        };
    }

    Consumer<Throwable> contributorsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading contributors");
            contributorStateBehaviorRelay.accept(ContributorState.builder()
                    .loading(false)
                    .errorRes(R.string.api_error_contributors)
                    .build()
            );
        };
    }
}
