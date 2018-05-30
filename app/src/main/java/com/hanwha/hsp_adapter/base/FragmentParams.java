/*
 * Copyright (C) Hanwha S&C Ltd., 2018. All rights reserved.
 *
 * This software is covered by the license agreement between
 * the end user and Hanwha S&C Ltd., and may be
 * used and copied only in accordance with the terms of the
 * said agreement.
 *
 * Hanwha S&C Ltd., assumes no responsibility or
 * liability for any errors or inaccuracies in this software,
 * or any consequential, incidental or indirect damage arising
 * out of the use of the software.
 */

package com.hanwha.hsp_adapter.base;

import android.os.Bundle;
import android.support.annotation.IdRes;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 30.. <p/>
 */
public class FragmentParams {
    @IdRes int containerViewId;
    Bundle bundle;
    Class<?> fragment;
    boolean addMode;
    boolean backStack;
    BaseFragmentManager.TransitionListener transitionListener;

    private FragmentParams(Builder builder) {
        this.containerViewId    = builder.containerViewId;
        this.fragment           = builder.fragment;
        this.bundle             = builder.bundle;
        this.backStack          = builder.backStack;
        this.transitionListener = builder.transitionListener;
        this.addMode            = builder.addMode;
    }

    public static Builder builder() {
        return new Builder();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //
    // Builder
    //
    ////////////////////////////////////////////////////////////////////////////////////

    public static class Builder {
        @IdRes int containerViewId;
        Bundle bundle;
        Class<?> fragment;
        boolean addMode   = false;
        boolean backStack = true;
        BaseFragmentManager.TransitionListener transitionListener;

        public Builder containerId(@IdRes int containerViewId) {
            this.containerViewId = containerViewId;
            return this;
        }

        public Builder fragment(Class<?> fragment) {
            this.fragment = fragment;
            return this;
        }

        public Builder fragment(Bundle bundle) {
            this.bundle = bundle;
            return this;
        }

        public Builder backStack(boolean backStack) {
            this.backStack = backStack;
            return this;
        }

        public Builder transitionListener(BaseFragmentManager.TransitionListener transitionListener) {
            this.transitionListener = transitionListener;
            return this;
        }

        public Builder addMode() {
            this.addMode   = true;
            this.backStack = false;
            return this;
        }

        public FragmentParams build() {
            return new FragmentParams(this);
        }
    }
}
