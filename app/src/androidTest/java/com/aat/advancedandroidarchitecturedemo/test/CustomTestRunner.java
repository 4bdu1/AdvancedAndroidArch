package com.aat.advancedandroidarchitecturedemo.test;

import android.app.Application;
import android.content.Context;

import androidx.test.runner.AndroidJUnitRunner;

import com.aat.advancedandroidarchitecturedemo.base.TestApplication;

/**
 * Created by 4bdul on 28/09/2019.
 */
public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestApplication.class.getName(), context);
    }
}


