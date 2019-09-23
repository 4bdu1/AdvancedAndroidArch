package com.aat.advancedandroidarchitecturedemo.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by 4bdul on 23/09/2019.
 */
public interface ScreenNavigator {

    void initWithRouter(Router router, Controller rootScreen);

    boolean pop();

    void clear();

}
