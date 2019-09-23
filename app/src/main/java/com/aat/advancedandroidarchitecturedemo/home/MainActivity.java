package com.aat.advancedandroidarchitecturedemo.home;

import com.aat.advancedandroidarchitecturedemo.R;
import com.aat.advancedandroidarchitecturedemo.base.BaseActivity;
import com.aat.advancedandroidarchitecturedemo.trending.TrendingReposController;
import com.bluelinelabs.conductor.Controller;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
