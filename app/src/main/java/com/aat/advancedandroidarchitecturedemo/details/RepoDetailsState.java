package com.aat.advancedandroidarchitecturedemo.details;

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

/**
 * Created by 4bdul on 29/09/2019.
 */
@AutoValue
abstract class RepoDetailsState {

    abstract boolean loading();

    @Nullable
    abstract String name();

    @Nullable
    abstract String description();

    @Nullable
    abstract String createdDate();

    @Nullable
    abstract String updatedDate();

    @Nullable
    abstract Integer errorRes();

    static Builder builder() {
        return new AutoValue_RepoDetailsState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder name(String name);

        abstract Builder description(String description);

        abstract Builder createdDate(String createdDate);

        abstract Builder updatedDate(String updatedDate);

        abstract Builder errorRes(Integer errorRes);

        abstract RepoDetailsState build();

    }
}
