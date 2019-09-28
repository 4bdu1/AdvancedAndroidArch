package com.aat.advancedandroidarchitecturedemo.base;

import androidx.test.InstrumentationRegistry;

/**
 * Created by 4bdul on 28/09/2019.
 */
public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent() {
        return (TestApplicationComponent)
                ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext()).component;
    }
}
