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

package com.hanwha.libhsp_adapter.arch.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;


import com.hanwha.libhsp_adapter.arch.adapter.HspAdapter;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 11.. <p/>
 */
public abstract class RecyclerViewModel<T> extends AndroidViewModel {
    public ObservableArrayList<T> items = new ObservableArrayList<>();
    public ObservableField<HspAdapter<T>> adapter = new ObservableField<>();

    public RecyclerViewModel(@NonNull Application application) {
        super(application);
    }

    public void initAdapter(@NonNull String id) {
        HspAdapter<T> adapter = new HspAdapter<>(id);
        adapter.setViewModel(this);

        this.adapter.set(adapter);
    }

    public void initAdapter(@NonNull String[] ids) {
        HspAdapter<T> adapter = new HspAdapter<>(ids);
        adapter.setViewModel(this);

        this.adapter.set(adapter);
    }

    public void setItems(ArrayList<T> items) {
        this.items.clear();
        this.items.addAll(items);
    }
}
