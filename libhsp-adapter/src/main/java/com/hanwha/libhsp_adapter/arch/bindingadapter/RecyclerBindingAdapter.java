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

package com.hanwha.libhsp_adapter.arch.bindingadapter;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hanwha.libhsp_adapter.arch.adapter.HspAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 9.. <p/>
 */
public class RecyclerBindingAdapter {
    private static final Logger mLog = LoggerFactory.getLogger(RecyclerBindingAdapter.class);

    @BindingAdapter({"bindAdapter", "bindItems"})
    public static void bindAdapter(@NonNull RecyclerView recycler, RecyclerView.Adapter adapter, ArrayList<?> items) {
        if (mLog.isTraceEnabled()) {
            mLog.trace("BIND ADAPTER");
        }

        HspAdapter hspadapter = (HspAdapter) adapter;
        if (recycler.getAdapter() == null) {
            recycler.setAdapter(adapter);
        } else {
            hspadapter = (HspAdapter) recycler.getAdapter();
        }

        hspadapter.setItems(recycler, items);
    }
}
