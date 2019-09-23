package com.aat.advancedandroidarchitecturedemo.base;

import android.content.Context;

import androidx.annotation.NonNull;

import com.aat.advancedandroidarchitecturedemo.di.Injector;
import com.bluelinelabs.conductor.Controller;

/**
 * Created by 4bdul on 23/09/2019.
 */
public abstract class BaseController extends Controller {

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        // Controller instances are retained across config changes,
        // so this method can called more than once. This therefore makes
        // sure we don't waste time injecting more than once.
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }
}
