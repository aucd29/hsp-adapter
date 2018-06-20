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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * {@code
 *     public class Navigator extends BaseFragmentManager {
 *         private static Navigator inst;
 *
 *         public static Navigator getInstance(FragmentActivity act) {
 *             if (inst == null) {
 *                 inst = new Navigator();
 *             }
 *
 *             inst.setFragmentManager(act);
 *
 *             return inst;
 *         }
 *
 *         private Navigator() {
 *
 *         }
 *     }
 *
 *     - example
 *     Navigator nv = Navigator.getInstance(this);
 *     nv.setBase(HomeFrgmt.class);
 *
 *     - change page
 *     nv.replace(OtherFrgmt.class);
 * }
 * </pre>
 *
 * @author <a href="mailto:aucd29@gmail.com">Burke Choi</a>
 */
public abstract class BaseFragmentManager {
    private static final Logger mLog = LoggerFactory.getLogger(BaseFragmentManager.class);

    protected FragmentManager mFrgmtManager;

    public BaseFragmentManager() {
    }

    public void setFragmentManager(FragmentActivity act) {
        if (act == null) {
            mLog.error("setFragmentManager act is null");
            return;
        }

        mFrgmtManager = act.getSupportFragmentManager();
    }

    public void setFragmentManager(Fragment frgmt) {
        if (frgmt == null) {
            mLog.error("setFragmentManager frgmt is null");
            return;
        }

        mFrgmtManager = frgmt.getChildFragmentManager();
    }

    public Fragment show(@NonNull FragmentParams params) {
        try {
            Fragment frgmt = instanceFragment(params.fragment);
            if (frgmt == null) {
                mLog.error("ERROR: frgmt == null");
                return null;
            }

            if (frgmt.isVisible()) {
                if (mLog.isDebugEnabled()) {
                    mLog.debug("VISIBLE FRAGMENT " + params.fragment.getSimpleName());
                }

                return frgmt;
            }

            if (params.bundle != null) {
                frgmt.setArguments(params.bundle);
            }

            FragmentTransaction trans = mFrgmtManager.beginTransaction();
            String tagName            = frgmt.getClass().getName();

            if (params.addMode) {
                trans.add(params.containerViewId, frgmt, tagName);
            } else {
                if (params.transitionListener != null) {
                    params.transitionListener.onEvent(this, trans);
                }

                trans.replace(params.containerViewId, frgmt, tagName);
            }

            if (params.backStack) {
                trans.addToBackStack(tagName);
            }

            trans.commit();

            return frgmt;
        } catch (Exception e) {
            e.printStackTrace();
            mLog.error("ERROR: " + e.getMessage());
        }

        return null;
    }

    private @Nullable Fragment instanceFragment(Class<?> clazz) {
        Fragment frgmt = mFrgmtManager.findFragmentByTag(clazz.getName());
        if (frgmt != null) {
            return frgmt;
        }

        try {
            return (Fragment) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            mLog.error("ERROR: " + e.getMessage());
        }

        return null;
    }

    @Deprecated
    public void add(int id, Class<?> cls) {
        add(id, cls, null);
    }

    @Deprecated
    public void add(int id, Class<?> cls, TransitionListener listener) {
        try {
            Fragment frgmt = (Fragment) cls.newInstance();
            if (frgmt == null) {
                mLog.error("setBase frgmt == null");
                return;
            }

            FragmentTransaction trans = mFrgmtManager.beginTransaction();
            if (frgmt.isVisible()) {
                return;
            }

            if (listener != null) {
                listener.onEvent(this, trans);
            }

            trans.add(id, frgmt, frgmt.getClass().getName());
            trans.commit();
        } catch (Exception e) {
            mLog.error(e.getMessage());
        }
    }

    @Deprecated
    public void resetAdd(int id, Class<?> cls) {
        replace(id, cls, false, null, null);
    }

    @Deprecated
    public Fragment replace(int id, Class<?> cls) {
        return replace(id, cls, true, null, null);
    }

    @Deprecated
    public Fragment replace(int id, Class<?> cls, TransitionListener listener) {
        return replace(id, cls, true, null, listener);
    }

    @Deprecated
    public Fragment replace(int id, Class<?> cls, Bundle bundle) {
        return replace(id, cls, true, bundle, null);
    }

    @Deprecated
    public Fragment replace(int id, Class<?> cls, Bundle bundle, TransitionListener listener) {
        return replace(id, cls, true, bundle, listener);
    }

    @Deprecated
    private Fragment replace(int id, Class<?> cls, boolean stack, Bundle bundle, TransitionListener listener) {
        try {
            Fragment frgmt = mFrgmtManager.findFragmentByTag(cls.getName());
            FragmentTransaction trans = mFrgmtManager.beginTransaction();

            if (frgmt != null && frgmt.isVisible()) {
                return frgmt;
            }

            frgmt = (Fragment) cls.newInstance();
            if (frgmt == null) {
                mLog.error("replace frgmt == null");
                return null;
            }

            if (bundle != null) {
                frgmt.setArguments(bundle);
            }

            if (stack) {
                if (listener != null) {
                    listener.onEvent(this, trans);
                } else {
//                    setTransition(trans);
                }
            }

            trans.replace(id, frgmt, frgmt.getClass().getName());

            if (stack) {
                trans.addToBackStack(frgmt.getClass().getName());
            }

            trans.commit();

            return frgmt;
        } catch (Exception e) {
            mLog.error(e.getMessage());
        }

        return null;
    }

    public void popBack() {
        if (mFrgmtManager != null) {
            mFrgmtManager.popBackStack();
        }
    }

    public void popBackAll() {
        if (mFrgmtManager == null) {
            mLog.error("setFragmentManager fm is null");
            return;
        }

        int count = mFrgmtManager.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            mFrgmtManager.popBackStack(i, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public Fragment getCurrentFragment() {
        if (mFrgmtManager == null) {
            return null;
        }

        int count = mFrgmtManager.getBackStackEntryCount();
        if (count > 0) {
            BackStackEntry frgmt = mFrgmtManager.getBackStackEntryAt(count - 1);
            return mFrgmtManager.findFragmentByTag(frgmt.getName());
        }

        return null;
    }

    public Fragment getFragment(Class<?> cls) {
        if (mFrgmtManager == null) {
            return null;
        }

        return mFrgmtManager.findFragmentByTag(cls.getName());
    }

    public int getChildCount() {
        if (mFrgmtManager == null) {
            return 0;
        }

        return mFrgmtManager.getBackStackEntryCount();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //
    // Transition Callback
    //
    ////////////////////////////////////////////////////////////////////////////////////

    public interface TransitionListener {
        void onEvent(BaseFragmentManager manager, FragmentTransaction trans);
    }

}
