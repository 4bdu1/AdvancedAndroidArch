package com.aat.advancedandroidarchitecturedemo.details;

import android.os.Bundle;

import com.aat.advancedandroidarchitecturedemo.R;
import com.aat.advancedandroidarchitecturedemo.base.BaseController;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by 4bdul on 28/09/2019.
 */
public class RepoDetailsController extends BaseController {

    static final String REPO_NAME_KEY = "repo_name";
    static final String REPO_OWNER_KEY = "repo_owner";

    public static Controller newInstance(String repoName, String repoOwner) {
        Bundle bundle = new Bundle();
        bundle.putString(REPO_NAME_KEY, repoName);
        bundle.putString(REPO_OWNER_KEY, repoOwner);
        return new RepoDetailsController(bundle);
    }

    public RepoDetailsController(Bundle bundle) {
        super(bundle);
    }


    @Override
    protected int layoutRes() {
        return R.layout.screen_repo_details;
    }
}
