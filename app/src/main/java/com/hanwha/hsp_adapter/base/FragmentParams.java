/*
 * Copyright (C) Hanwha System Corp. 2018. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
